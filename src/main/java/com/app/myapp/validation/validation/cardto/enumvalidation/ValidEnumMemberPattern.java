package com.app.myapp.validation.validation.cardto.enumvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {EnumValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnumMemberPattern {
    String message() default "Given value is not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String regexp();
}