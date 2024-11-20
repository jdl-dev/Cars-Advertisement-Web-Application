package com.app.myapp.model.validation;

import com.app.myapp.model.Bodytype;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumBodyTypeValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Bodytype> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Bodytype bodytype, ConstraintValidatorContext context) {
        if (bodytype == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Bodytype value is not valid " + bodytype)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == bodytype)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Bodytype value is not valid " + bodytype)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
