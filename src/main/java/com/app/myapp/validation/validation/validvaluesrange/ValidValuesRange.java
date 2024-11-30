package com.app.myapp.validation.validation.validvaluesrange;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ValidValuesRangeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidValuesRange {
    String message() default "Given range is not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min();

    int max();

    String minField();

    String maxField();
}