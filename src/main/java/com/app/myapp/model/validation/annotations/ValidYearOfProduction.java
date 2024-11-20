package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.YearOfProduction;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = YearOfProduction.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidYearOfProduction {
    String message() default "Invalid Year Of Production";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min();

    int max();
}