package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annotations.ValidDoorNumbers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoorNumberValidator implements ConstraintValidator<ValidDoorNumbers, Integer> {

    private int minDoorNumber;
    private int maxDoorNumber;

    @Override
    public void initialize(ValidDoorNumbers constraintAnnotation) {
        this.minDoorNumber = constraintAnnotation.min();
        this.maxDoorNumber = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer doorNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (doorNumber < minDoorNumber) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Door number must be at least " + minDoorNumber)
                    .addConstraintViolation();
            return false;
        }

        if (doorNumber > maxDoorNumber) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Door number must be at most " + maxDoorNumber)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
