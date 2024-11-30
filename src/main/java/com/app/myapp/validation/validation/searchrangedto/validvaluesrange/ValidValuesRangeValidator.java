package com.app.myapp.validation.validation.searchrangedto.validvaluesrange;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import java.lang.reflect.Field;

public class ValidValuesRangeValidator implements ConstraintValidator<ValidValuesRange, Object> {
    private int minConstraint;
    private int maxConstraint;
    private String minField;
    private String maxField;

    @Override
    public void initialize(ValidValuesRange constraintAnnotation) {
        this.minConstraint = constraintAnnotation.min();
        this.maxConstraint = constraintAnnotation.max();
        this.minField = constraintAnnotation.minField();
        this.maxField = constraintAnnotation.maxField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Class<?> clazz = object.getClass();

        try {

            Field minClazzField = clazz.getDeclaredField(minField);
            Field maxClazzField = clazz.getDeclaredField(maxField);

            minClazzField.setAccessible(true);
            maxClazzField.setAccessible(true);

            int minValue;
            int maxValue;

            if (minClazzField.getType().equals(int.class)) {
                minValue = (int) minClazzField.get(object);
                maxValue = (int) maxClazzField.get(object);
            } else {
                minValue = Integer.parseInt((String) minClazzField.get(object));
                maxValue = Integer.parseInt((String) maxClazzField.get(object));
            }

            HibernateConstraintValidatorContext hibernateContext =
                    constraintValidatorContext.unwrap(HibernateConstraintValidatorContext.class);

            if (minValue < minConstraint) {
                hibernateContext.disableDefaultConstraintViolation();
                hibernateContext
                        .addMessageParameter("min", minValue)
                        .addMessageParameter("minValue", minConstraint)
                        .buildConstraintViolationWithTemplate("{valueIsNotCorrect.toSmall}")
                        .addConstraintViolation();

                return false;
            }


            if (maxValue > maxConstraint) {
                hibernateContext.disableDefaultConstraintViolation();
                hibernateContext
                        .addMessageParameter("max", maxValue)
                        .addMessageParameter("maxValue", maxConstraint)
                        .buildConstraintViolationWithTemplate("{valueIsNotCorrect.toBig}")
                        .addConstraintViolation();

                return false;
            }

            if (minValue > maxValue) {
                hibernateContext.disableDefaultConstraintViolation();
                hibernateContext
                        .addMessageParameter("min", minValue)
                        .addMessageParameter("max", maxValue)
                        .buildConstraintViolationWithTemplate("{valueIsNotCorrect.minTooBigMaxTooSmall}")
                        .addConstraintViolation();

                return false;
            }

            return true;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
