package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annoations.ValidYearOfProduction;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearOfProduction implements ConstraintValidator<ValidYearOfProduction, Year> {
    private int minYear;
    private int currentYear;

    @Override
    public void initialize(ValidYearOfProduction constraintAnnotation) {
        this.minYear = constraintAnnotation.min();
        this.currentYear = Year.now().getValue();
    }

    @Override
    public boolean isValid(Year yearOfProduction, ConstraintValidatorContext context) {
        if (yearOfProduction.getValue() < minYear) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Year must be at least " + minYear)
                    .addConstraintViolation();
            return false;
        }

        if (yearOfProduction.getValue() > currentYear) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Year must be at most " + currentYear)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
