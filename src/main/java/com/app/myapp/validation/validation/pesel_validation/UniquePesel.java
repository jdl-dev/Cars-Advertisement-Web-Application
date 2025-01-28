package com.app.myapp.validation.validation.pesel_validation;

import jakarta.validation.Payload;

public @interface UniquePesel {
    String message() default "Given PESEL is not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
