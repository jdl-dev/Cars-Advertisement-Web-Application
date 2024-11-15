package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annoations.ValidDateOfAddingTheAdd;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateOfAddingTheAdd implements ConstraintValidator<ValidDateOfAddingTheAdd, LocalDateTime> {
    private int maxDelay;

    @Override
    public void initialize(ValidDateOfAddingTheAdd constraintAnnotation) {
        this.maxDelay = constraintAnnotation.maxDelay();
    }

    @Override
    public boolean isValid(LocalDateTime clientTime, ConstraintValidatorContext context) {
        var serverTime = LocalDateTime.now();
        Duration duration = Duration.between(clientTime, serverTime);
        long seconds = duration.getSeconds() % 60;

        if (seconds > maxDelay) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Different between client side time and server side time is to big: " + seconds)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}