package com.heepoke.app.domain.enums;

public enum MessageConstants {
    SUCCESS("0000", "Success"),
    FAILED("0001", "Fail"),
    NOT_FOUND("0002", "Not Found"),
    DUPLICATE("0003", "Duplicate"),
    INVALID("0004", "Invalid");

    private final String code;
    private final String message;

    private MessageConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}