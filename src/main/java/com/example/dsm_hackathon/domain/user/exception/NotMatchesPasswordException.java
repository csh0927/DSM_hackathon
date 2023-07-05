package com.example.dsm_hackathon.domain.user.exception;

import com.example.dsm_hackathon.global.error.ErrorCode;
import com.example.dsm_hackathon.global.error.handler.AidgoException;

public class NotMatchesPasswordException extends AidgoException {

    public static final AidgoException EXCEPTION = new NotMatchesPasswordException();

    private NotMatchesPasswordException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}