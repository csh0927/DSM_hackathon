package com.example.dsm_hackathon.global.exception;


import com.example.dsm_hackathon.global.error.ErrorCode;
import com.example.dsm_hackathon.global.error.handler.AidgoException;

public class ExpiredJwtException extends AidgoException {
    public static final AidgoException EXCEPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
