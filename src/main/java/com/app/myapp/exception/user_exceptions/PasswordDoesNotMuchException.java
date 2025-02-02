package com.app.myapp.exception.user_exceptions;

public class PasswordDoesNotMuchException extends RuntimeException {
    public PasswordDoesNotMuchException(String message) {
        super(message);
    }
}
