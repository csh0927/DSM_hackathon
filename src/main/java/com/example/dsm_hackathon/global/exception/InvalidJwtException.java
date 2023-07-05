package com.example.dsm_hackathon.global.exception;

import com.example.dsm_hackathon.global.error.ErrorCode;
import com.example.dsm_hackathon.global.error.handler.AidgoException;

public class InvalidJwtException extends AidgoException {
    public static final AidgoException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
