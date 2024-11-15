package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.PriceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {PriceValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrice {
    String message() default "Price is not correct";

    int minPrice() default 5;

    int maxPrice() default 100000000;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}