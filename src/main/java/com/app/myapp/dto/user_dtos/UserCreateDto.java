package com.app.myapp.dto.user_dtos;

import com.app.myapp.model.model.user_members.Gender;
import com.app.myapp.validation.validation.email_validation.UniqueEmail;
import com.app.myapp.validation.validation.pesel_validation.UniquePesel;
import com.app.myapp.validation.validation.phone_number_validation.ValidPhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class UserCreateDto {

    @NotBlank(message = "Name must be given")
    private String name;

    @NotBlank(message = "Username must be given")
    private String username;

    @NotBlank(message = "Surname must be given")
    private String surname;

    @NotBlank(message = "Date of birth must be given")
    private LocalDate birthday;

    @NotBlank(message = "Email must be given")
    @UniqueEmail
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "Password must contain at least one letter, one number, and one special character")
    private String password;

    @NotBlank(message = "Phone number must be given")
    @ValidPhoneNumber
    private String phone;

    @NotBlank(message = "Address must be given")
    private String address;

    @NotBlank(message = "City must be given")
    private String city;

    @NotBlank(message = "PESEL must be given")
    @UniquePesel
    private String pesel;

    @NotNull(message = "Gender must be given")
    private Gender gender;
}