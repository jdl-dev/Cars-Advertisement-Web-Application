package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annotations.ValidAmountOfSeats;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AmountOfSeatsValidator implements ConstraintValidator<ValidAmountOfSeats, Integer> {

    private int minAmountOfSeats;
    private int maxAmountOfSeats;

    @Override
    public void initialize(ValidAmountOfSeats constraintAnnotation) {
        this.minAmountOfSeats = constraintAnnotation.min();
        this.maxAmountOfSeats = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer seats, ConstraintValidatorContext constraintValidatorContext) {
        if (seats < minAmountOfSeats) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Seats must be at least " + minAmountOfSeats)
                    .addConstraintViolation();
            return false;
        }

        if (seats > maxAmountOfSeats) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Seats must be at most " + maxAmountOfSeats)
                    .addConstraintViolation();
            return false;
        }

        return false;
    }
}