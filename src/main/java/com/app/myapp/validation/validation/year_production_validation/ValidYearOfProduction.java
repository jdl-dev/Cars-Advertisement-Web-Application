package com.app.myapp.validation.validation.year_production_validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {YearOfProductionValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidYearOfProduction {
    String message() default "Given year of production is not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minProductionYear();

    int maxProductionYear();
}
