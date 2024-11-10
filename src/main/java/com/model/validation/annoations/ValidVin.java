package com.model.validation.annoations;

import com.model.validation.VinValidator;

import javax.validation.Constraint;
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
}
