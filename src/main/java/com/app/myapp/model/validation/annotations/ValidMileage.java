package com.app.myapp.model.validation.annotations;

import com.app.myapp.model.validation.MileageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = MileageValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMileage {
    String message() default "Mileage is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minMileage();

    int maxMileage();
}
