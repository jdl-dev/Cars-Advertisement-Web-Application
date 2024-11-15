package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annoations.ValidAmountOfSeats;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AmountOfSeatsValidator implements ConstraintValidator<ValidAmountOfSeats, Integer> {

    private int minAmountOfSeats;
    private int maxAmountOfSeats;

    @Override
    public void initialize(ValidAmountOfSeats constraintAnnotation) {
        this.minAmountOfSeats = constraintAnnotation.minSeats();
        this.maxAmountOfSeats = constraintAnnotation.maxSeats();
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