package model.validation;

import model.validation.annoations.ValidPrice;

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
        if (price > maxPrice) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Give price is to big")
                    .addConstraintViolation();
        }

        if (price < minPrice) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Given price cannot be equal or less than 0")
                    .addConstraintViolation();
        }

        if (price == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Price cannot be null ")
                    .addConstraintViolation();
        }

        return false;
    }
}
