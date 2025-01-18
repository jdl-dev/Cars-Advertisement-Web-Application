package com.app.myapp.validation.validation.phone_number_validation;

import jakarta.validation.Payload;

public @interface ValidPhoneNumber {
    String message() default "Given phone number is not correct.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
