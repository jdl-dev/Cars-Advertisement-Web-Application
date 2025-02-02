package com.app.myapp.exception.other_purpose_exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class DataFromUserNotValidException extends RuntimeException {
    private final Set<String> errorMessages;
}
