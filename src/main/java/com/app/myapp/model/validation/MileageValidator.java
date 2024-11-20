package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annotations.ValidMileage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MileageValidator implements ConstraintValidator<ValidMileage, Integer> {
    private int minMileage;
    private int maxMileage;

    @Override
    public void initialize(ValidMileage constraintAnnotation) {
        this.minMileage = constraintAnnotation.min();
        this.maxMileage = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer mileage, ConstraintValidatorContext context) {
        if (mileage < minMileage) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Mileage must be at least " + minMileage)
                    .addConstraintViolation();
            return false;
        }

        if (mileage > maxMileage) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Mileage must be at most " + maxMileage)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
