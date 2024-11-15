package com.app.myapp.model.validation;


import com.app.myapp.model.Petrol;
import com.app.myapp.model.validation.annoations.ValidEnumMembersOfCarClass;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumPetrolValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Petrol> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Petrol petrol, ConstraintValidatorContext context) {
        if (petrol == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Petrol value is not valid " + petrol)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == petrol)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Petrol value is not valid " + petrol)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}