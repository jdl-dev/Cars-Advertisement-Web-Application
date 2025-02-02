package com.app.myapp.exception.other_purpose_exceptions;

public class InvalidSearchRangeException extends RuntimeException {
    public InvalidSearchRangeException(String message) {
        super(message);
    }
}
