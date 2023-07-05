package com.example.dsm_hackathon.global.error.handler;

import com.example.dsm_hackathon.global.error.ErrorCode;
import com.example.dsm_hackathon.global.error.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (AidgoException e) {
            ErrorCode errorCode = e.getErrorCode();
            response.setStatus(errorCode.getStatus());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

            objectMapper.writeValue(response.getWriter(), errorResponse);
        }
    }

}
