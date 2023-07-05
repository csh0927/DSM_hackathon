package com.example.dsm_hackathon.domain.user.controller;

import com.example.dsm_hackathon.domain.user.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public String emailConfirm(@RequestParam String email) throws MessagingException, UnsupportedEncodingException {
        String authCode = emailService.sendEmail(email);

        return authCode;
    }
}
