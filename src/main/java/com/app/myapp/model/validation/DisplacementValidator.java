package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annotations.ValidDisplacement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DisplacementValidator implements ConstraintValidator<ValidDisplacement, Integer> {
    private int minDisplacement;
    private int maxDisplacement;

    @Override
    public void initialize(ValidDisplacement constraintAnnotation) {
        minDisplacement = constraintAnnotation.minDisplacement();
        maxDisplacement = constraintAnnotation.maxDisplacement();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext context) {
        if (integer < minDisplacement) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Displacement must be at least " + minDisplacement)
                    .addConstraintViolation();
            return false;
        }

        if (integer > maxDisplacement) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Displacement must be at most " + maxDisplacement)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
