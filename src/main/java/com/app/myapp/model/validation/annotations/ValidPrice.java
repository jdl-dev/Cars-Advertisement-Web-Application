package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.PriceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrice {
    String message() default "Price is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minPrice();

    int maxPrice();
}