package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.AmountOfSeatsValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
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
    String message() default "{com.app.myapp.model.validation.annoations.AmountOfSeats}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minSeats() default 1;

    int maxSeats() default 100;
}
