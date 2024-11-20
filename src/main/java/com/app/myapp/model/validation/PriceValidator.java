package com.app.myapp.model.validation;

import com.app.myapp.model.validation.annotations.ValidPrice;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<ValidPrice, Integer> {
    private int minPrice;
    private int maxPrice;

    @Override
    public void initialize(ValidPrice constraintAnnotation) {
        this.minPrice = constraintAnnotation.minPrice();
        this.maxPrice = constraintAnnotation.maxPrice();
    }

    @Override
    public boolean isValid(Integer price, ConstraintValidatorContext context) {
        if (price < minPrice) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Price must be at least" + minPrice)
                    .addConstraintViolation();
            return false;
        }

        if (price > maxPrice) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Price must be at most" + maxPrice)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
