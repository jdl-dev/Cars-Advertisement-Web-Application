package com.model.validation.annoations;

import com.model.validation.DisplacementValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DisplacementValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDisplacement {
    public String message() default "Displacement is not valid";

    public int minDisplacement() default 1;

    public int maxDisplacement() default 10000;
}
