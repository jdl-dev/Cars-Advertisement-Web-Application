package com.app.myapp.validation.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumPetrolValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, String> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {


        return true;
    }
}