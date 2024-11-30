package com.app.myapp.validation.validation.yearproductionvalidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;


import java.time.Year;

public class YearOfProductionValidator implements ConstraintValidator<ValidYearOfProduction, Year> {

    private int minProductionYear;
    private int maxProductionYear;

    @Override
    public void initialize(ValidYearOfProduction constraintAnnotation) {
        this.minProductionYear = constraintAnnotation.minProductionYear();
        this.maxProductionYear = Year.now().getValue();
    }

    @Override
    public boolean isValid(Year year, ConstraintValidatorContext constraintValidatorContext) {
        int yearOfProduction = year.getValue();

        if (yearOfProduction < minProductionYear) {
            HibernateConstraintValidatorContext hibernateContext =
                    constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);

            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext
                    .addMessageParameter("min", minProductionYear)
                    .buildConstraintViolationWithTemplate("{yearOfProduction.min}")
                    .addConstraintViolation();
            return false;
        }
        if (yearOfProduction > maxProductionYear) {
            HibernateConstraintValidatorContext hibernateContext =
                    constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);

            hibernateContext.disableDefaultConstraintViolation();
            hibernateContext
                    .addMessageParameter("max", maxProductionYear)
                    .buildConstraintViolationWithTemplate("{yearOfProduction.max}")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
