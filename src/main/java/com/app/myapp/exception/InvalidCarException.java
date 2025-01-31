package com.app.myapp.exception;

public class InvalidCarException extends RuntimeException {
    public InvalidCarException(String message) {
        super(message);
    }
}