package com.app.myapp.model.validation;

import com.app.myapp.model.State;
import com.app.myapp.model.validation.annoations.ValidEnumMembersOfCarClass;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumStateValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, State> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(State condition, ConstraintValidatorContext context) {
        if (condition == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Condition value is not valid " + condition)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == condition)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Condition value is not valid " + condition)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
