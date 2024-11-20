package com.app.myapp.model.validation;

import com.app.myapp.model.Gearbox;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumGearboxValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, Gearbox> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(Gearbox gearbox, ConstraintValidatorContext context) {
        if (gearbox == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Gearbox value is not valid " + gearbox)
                    .addConstraintViolation();
            return false;
        }

        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == gearbox)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Gearbox value is not valid " + gearbox)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
