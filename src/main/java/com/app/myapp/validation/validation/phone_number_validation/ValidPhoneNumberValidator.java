package com.app.myapp.validation.validation.phone_number_validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private final static String PHONE_NUMBER_REGEX = "^(\\+48\\s?)?(\\(?\\d{2}\\)?\\s?)?[\\d\\s-]{7,9}$";

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.matches(PHONE_NUMBER_REGEX)) {
            return true;
        }

        return false;
    }

}
