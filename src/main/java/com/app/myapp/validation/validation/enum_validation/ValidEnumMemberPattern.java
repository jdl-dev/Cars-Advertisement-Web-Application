package com.app.myapp.validation.validation.enum_validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {EnumValidator.class})
@Target({ElementType.TYPE_USE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnumMemberPattern {
    String regexp();

    String message() default "Does not mmatch given pattern.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}