package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.VinValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = VinValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVin {
    String message() default "Invalid VIN";

    String regex() default "\b[(A-H|J-N|P|R-Z|0-9)]{17}\b";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}