package com.app.myapp.model.validation.annoations;

import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnumMembersOfCarClass {
    String message() default "Invalid value. This is not permitted.";

    Class<? extends Enum<?>> enumClass();
}