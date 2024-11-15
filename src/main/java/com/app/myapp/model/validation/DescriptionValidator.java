package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annoations.ValidDescription;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DescriptionValidator implements ConstraintValidator<ValidDescription, String> {
    int maxDescriptionLength;

    @Override
    public void initialize(ValidDescription constraintAnnotation) {
        this.maxDescriptionLength = constraintAnnotation.maxDescriptionLength();
    }

    @Override
    public boolean isValid(String description, ConstraintValidatorContext context) {
        if (description.length() > maxDescriptionLength) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Description length is to long. Maxial description length is " + description)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
