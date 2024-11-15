package com.app.myapp.model.validation;

import com.app.myapp.model.Gearbos;
import com.app.myapp.model.validation.annoations.ValidEnumMembersOfCarClass;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumGearboxValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Gearbos> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Gearbos gearbos, ConstraintValidatorContext context) {
        if (gearbos == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Gearbox value is not valid " + gearbos)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == gearbos)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Gearbox value is not valid " + gearbos)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}