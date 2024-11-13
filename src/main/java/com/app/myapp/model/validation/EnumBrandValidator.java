package com.app.myapp.model.validation;

import com.app.myapp.model.Brand;
import com.app.myapp.model.validation.annoations.ValidEnumMembersOfCarClass;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumBrandValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Brand> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Brand brand, ConstraintValidatorContext context) {
        if (brand == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Brand value is not valid " + brand)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == brand)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Brand value is not valid " + brand)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
