package com.bosonit.restservice.content.exception.response;

import lombok.Getter;

import java.util.Date;

@Getter
public class CustomError {
    private final Date timestamp = new Date();
    private int HttpCode;
    private String message;

    public CustomError(int HttpCode, String message) {
        this.HttpCode = HttpCode;
        this.message = message;
    }
}
