package com.example.dsm_hackathon.domain.user.controller;

import com.example.dsm_hackathon.domain.user.controller.request.LoginRequest;
import com.example.dsm_hackathon.domain.user.controller.request.SignupRequest;
import com.example.dsm_hackathon.domain.user.controller.response.TokenResponse;
import com.example.dsm_hackathon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request){
        userService.signup(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request){
        return userService.login(request);
    }
}
