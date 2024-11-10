package model.validation.annoations;

import model.validation.MileageValidator;

import javax.validation.Constraint;
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

    int minMileage() default 0;

    int maxMileage() default 30000000;
}
