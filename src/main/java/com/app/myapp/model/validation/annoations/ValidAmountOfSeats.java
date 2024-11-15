package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.AmountOfSeatsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = AmountOfSeatsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAmountOfSeats {
    String message() default "Amount of seats is not proper";

    int minSeats() default 1;

    int maxSeats() default 100;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}