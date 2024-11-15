package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annoations.ValidPower;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PowerValidator implements ConstraintValidator<ValidPower, Integer> {
    private int minPower;
    private int maxPower;

    @Override
    public void initialize(ValidPower constraintAnnotation) {
        this.minPower = constraintAnnotation.min();
        this.maxPower = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        if (integer < minPower) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Power must be at least" + minPower)
                    .addConstraintViolation();
            return false;
        }

        if (integer > maxPower) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Power must be at most" + maxPower)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}