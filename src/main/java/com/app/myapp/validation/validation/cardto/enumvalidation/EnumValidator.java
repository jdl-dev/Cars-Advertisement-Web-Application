package com.app.myapp.validation.validation.cardto.enumvalidation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnumValidator implements ConstraintValidator<ValidEnumMemberPattern, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(ValidEnumMemberPattern constraintAnnotation) {
        this.pattern = Pattern.compile(constraintAnnotation.regexp());
    }

    @Override
    public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext context) {
        Matcher m = pattern.matcher(anEnum.name());

        return m.matches();
    }
}