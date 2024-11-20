package com.app.myapp.model.validation;

import com.app.myapp.model.validation.descriptionvalidation.DescriptionForbiddenWordsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DescriptionForbiddenWordsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDescription {
    String message() default "Description is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
