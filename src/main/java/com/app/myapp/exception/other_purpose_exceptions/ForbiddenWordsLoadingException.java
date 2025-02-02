package com.app.myapp.exception.other_purpose_exceptions;

public class ForbiddenWordsLoadingException extends RuntimeException {
    public ForbiddenWordsLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
