package model.validation;

import model.validation.annoations.ValidDoorNumbers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class DoorNumberValidator implements ConstraintValidator<ValidDoorNumbers, Integer> {

    private int minDoorNumber;
    private int maxDoorNumber;

    @Override
    public void initialize(ValidDoorNumbers constraintAnnotation) {
        this.minDoorNumber = constraintAnnotation.minDoorNumber();
        this.maxDoorNumber = constraintAnnotation.maxDoorNumber();
    }

    @Override
    public boolean isValid(Integer doorNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (doorNumber < minDoorNumber) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Door number must be at least " + minDoorNumber)
                    .addConstraintViolation();
            return false;
        }

        if (doorNumber > maxDoorNumber) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Door number must be at most " + maxDoorNumber)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
