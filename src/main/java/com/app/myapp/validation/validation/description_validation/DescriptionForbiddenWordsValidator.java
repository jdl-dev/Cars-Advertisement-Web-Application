package com.app.myapp.validation.validation.description_validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Set;

public class DescriptionForbiddenWordsValidator implements ConstraintValidator<ValidDescriptionForbiddenWords, String> {

    private Set<String> forbiddenWords;

    @Override
    public void initialize(ValidDescriptionForbiddenWords constraintAnnotation) {
        this.forbiddenWords = new ForbiddenWordsLoader().loadForbiddenWords(constraintAnnotation.forbiddenWords());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        for (String forbiddenWord : forbiddenWords) {

            if (s.compareToIgnoreCase(forbiddenWord) == 0) {
                return false;

            }
        }
        return true;
    }
}