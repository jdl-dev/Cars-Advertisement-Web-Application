package com.app.myapp.validation.validation.email_validation;

import jakarta.validation.Payload;

public @interface UniqueEmail {
    String message() default "Given email is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
