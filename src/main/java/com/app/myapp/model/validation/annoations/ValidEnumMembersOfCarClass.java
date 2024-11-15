package com.app.myapp.model.validation.annoations;

import com.app.myapp.model.validation.EnumBodyTypeValidator;
import com.app.myapp.model.validation.EnumBrandValidator;
import com.app.myapp.model.validation.EnumColorPaletteValidator;
import com.app.myapp.model.validation.EnumGearboxValidator;
import com.app.myapp.model.validation.EnumPetrolValidator;
import com.app.myapp.model.validation.EnumStateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {
        EnumBrandValidator.class,
        EnumPetrolValidator.class,
        EnumGearboxValidator.class,
        EnumBodyTypeValidator.class,
        EnumColorPaletteValidator.class,
        EnumStateValidator.class
})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnumMembersOfCarClass {
    String message() default "Invalid value. This is not permitted.";

    Class<? extends Enum<?>> enumClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}