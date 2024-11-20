package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.DoorNumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DoorNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDoorNumbers {
    String message() default "Door number is not valid";

    int minDoorNumber() default 1;

    int maxDoorNumber() default 12;
}
