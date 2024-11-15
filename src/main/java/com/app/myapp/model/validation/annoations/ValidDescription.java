package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.DescriptionValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DescriptionValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDescription {
    String message() default "Description is not valid";

    int maxDescriptionLength() default 2500;
}
