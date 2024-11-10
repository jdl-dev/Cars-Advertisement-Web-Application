package model.validation;

import model.validation.annoations.ValidVin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VinValidator implements ConstraintValidator<ValidVin, String> {
    private String vinRegex;

    @Override
    public void initialize(ValidVin constraintAnnotation) {
        this.vinRegex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String vin, ConstraintValidatorContext context) {
        if (!vin.matches(vinRegex)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Vin is not correct")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}