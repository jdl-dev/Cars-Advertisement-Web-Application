package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.DisplacementValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
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

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public int minDisplacement();

    public int maxDisplacement();
}
