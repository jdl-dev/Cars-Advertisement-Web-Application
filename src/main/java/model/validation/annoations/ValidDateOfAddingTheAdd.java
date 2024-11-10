package model.validation.annoations;

import model.validation.DateOfAddingTheAdd;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DateOfAddingTheAdd.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateOfAddingTheAdd {
    String message() default "Invalid Date of Adding";
}
