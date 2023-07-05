package com.example.dsm_hackathon.domain.user.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
}
