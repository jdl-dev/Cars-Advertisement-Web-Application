package com.app.myapp.dto;

import com.app.myapp.model.model.Car;
import com.app.myapp.validation.payloads.Severity;
import com.app.myapp.validation.validation.email_validation.UniqueEmail;
import com.app.myapp.validation.validation.enum_validation.ValidEnumMemberPattern;
import com.app.myapp.validation.validation.pesel_validation.UniquePesel;
import com.app.myapp.validation.validation.phone_number_validation.ValidPhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private LocalDate birthday;

    @NotBlank
    @UniqueEmail
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @ValidPhoneNumber
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    @UniquePesel
    private String pesel;

    @NotNull
    @ValidEnumMemberPattern(
            regexp = "MALE|FEMALE",
            message = "{gender.incorrect}",
            payload = Severity.Error.class)
    private String gender;
    private List<Car> advertisements;
}
