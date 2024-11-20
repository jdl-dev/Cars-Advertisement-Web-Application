package com.app.myapp.model.validation;

import com.app.myapp.model.ColorPalette;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class EnumColorPaletteValidator implements ConstraintValidator<ValidEnumMembersOfCarClass, ColorPalette> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(ValidEnumMembersOfCarClass constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(ColorPalette colorPalette, ConstraintValidatorContext context) {
        if (Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e == colorPalette)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Color palette value is not valid " + colorPalette)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}