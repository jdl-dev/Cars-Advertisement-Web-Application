package model.validation;

import model.Brand;
import model.validation.annoations.ValidEnumMembersOfCarClass;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
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
