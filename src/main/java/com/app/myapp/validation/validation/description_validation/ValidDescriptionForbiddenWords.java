package com.app.myapp.validation.validation.description_validation;

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
public @interface ValidDescriptionForbiddenWords {
    String message() default "Given description contains not allowed words.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String forbiddenWords();
}
