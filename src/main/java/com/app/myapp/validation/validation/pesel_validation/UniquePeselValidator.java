package com.app.myapp.validation.validation.pesel_validation;

import com.app.myapp.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UniquePeselValidator implements ConstraintValidator<UniquePesel, String> {

    private final String PESEL_REGEX = "^([0-9]{2})((0[1-9]|1[0-2])|(2[1-9]|3[0-2])|(4[1-9]|5[0-2])|(6[1-9]|7[0-2])|(8[1-9]|9[0-2]))([0-2][0-9]|3[0-1])\\d{5}$";
    @Autowired
    private UserRepository userRepository;
    private List<String> PESELs;

    @Override
    public void initialize(UniquePesel constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.PESELs = userRepository.findTableWithPesels();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.matches(PESEL_REGEX)) {

            if (PESELs.contains(value)) {
                return false;
            }

            return true;
        }

        return false;
    }

}
