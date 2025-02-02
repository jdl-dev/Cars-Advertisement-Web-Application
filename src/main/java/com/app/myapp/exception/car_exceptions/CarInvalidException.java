package com.app.myapp.exception.car_exceptions;

public class CarInvalidException extends RuntimeException {
    public CarInvalidException(String message) {
        super(message);
    }
}