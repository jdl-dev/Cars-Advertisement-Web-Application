package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.YearOfProduction;
import jakarta.validation.Constraint;

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

    int min() default 1850;

    int max() default 9999;
}
