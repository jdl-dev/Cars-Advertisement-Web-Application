package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.PowerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PowerValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPower {
    String message() default "Invalid power value";

    int min() default 1;

    int max() default 5000;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}