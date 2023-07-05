package com.example.dsm_hackathon.global.error.handler;

import com.example.dsm_hackathon.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AidgoException extends RuntimeException {
    private final ErrorCode errorCode;
}
