package com.model.validation;

import com.model.Condition;
import com.model.validation.annoations.ValidEnumMembersOfCarClass;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumConditionValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Condition> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Condition condition, ConstraintValidatorContext context) {
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
