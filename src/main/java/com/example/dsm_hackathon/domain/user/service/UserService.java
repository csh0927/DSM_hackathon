package com.example.dsm_hackathon.domain.user.service;

import com.example.dsm_hackathon.domain.user.controller.request.LoginRequest;
import com.example.dsm_hackathon.domain.user.controller.request.SignupRequest;
import com.example.dsm_hackathon.domain.user.controller.response.TokenResponse;
import com.example.dsm_hackathon.domain.user.domain.User;
import com.example.dsm_hackathon.domain.user.domain.UserRepository;
import com.example.dsm_hackathon.domain.user.exception.NotMatchesPasswordException;
import com.example.dsm_hackathon.domain.user.exception.UserNotFoundException;
import com.example.dsm_hackathon.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void signup(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserNotFoundException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .name(request.getName())
                .birth(request.getBirth())
                .email(request.getEmail())
                .inSchool(request.getInSchool())
                .schoolName(request.getSchoolName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }

    @Transactional
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw NotMatchesPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.createAccessToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}

