package com.app.myapp.model.validation;

import com.app.myapp.model.Brand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumBrandValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Brand> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Brand brand, ConstraintValidatorContext context) {
        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == brand)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Brand value is not valid " + brand)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}