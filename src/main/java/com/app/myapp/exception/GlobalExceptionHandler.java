package com.app.myapp.exception;

import com.app.myapp.exception.other_purpose_exceptions.DataFromUserNotValidException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleException(DataAccessException exception) {
        return ResponseEntity
                .internalServerError()
                .body(exception.getMessage());
    }

    @ExceptionHandler(DataFromUserNotValidException.class)
    public ResponseEntity<?> handleException(DataFromUserNotValidException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getErrorMessages());
    }
}