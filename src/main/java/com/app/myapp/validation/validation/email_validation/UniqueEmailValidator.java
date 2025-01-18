package com.app.myapp.validation.validation.email_validation;

import com.app.myapp.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private static String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    @Autowired
    private UserRepository userRepository;
    private List<String> emails;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.emails = userRepository.findTableWithEmails();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        if (value.matches(EMAIL_REGEX)) {

            if (emails.contains(value)) {
                return false;
            }

            return true;
        }

        return false;
    }
}
