package com.example.dsm_hackathon.global.security.jwt;

import com.example.dsm_hackathon.global.exception.ExpiredJwtException;
import com.example.dsm_hackathon.global.exception.InvalidJwtException;
import com.example.dsm_hackathon.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access_exp}")
    private Long accessExp;

    private static final String AUTHORIZATION_HEADER = "authorization";
    private static final String BEARER_PREFIX = "BEARER";

    private final AuthDetailsService authDetailsService;

    public String createAccessToken(String email) {
        return createToken(email, "access", accessExp);
    }

    private String createToken(String email, String typ, Long exp) {

        return Jwts.builder()
                .setSubject(email)
                .claim("typ", typ)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailsService.loadUserByUsername(getEmail(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getEmail(String token){
        return getClaims(token).getSubject();
    }
    private Claims getClaims(String token){
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            throw ExpiredJwtException.EXCEPTION;
        }catch (Exception e){
            throw InvalidJwtException.EXCEPTION;
        }
    }

    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader(AUTHORIZATION_HEADER);
        if(token != null && token.length() > 7 && token.startsWith(BEARER_PREFIX)){
            return token.substring(7);
        }
        return null;
    }
}