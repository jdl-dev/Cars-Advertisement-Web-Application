package com.app.myapp.dto;

import com.app.myapp.model.model.Car;
import com.app.myapp.model.model.user_members.Gender;
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
    private String surname;

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
    private Gender gender;

    private List<Car> advertisements;

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank String surname) {
        this.surname = surname;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(@NotBlank LocalDate birthday) {
        this.birthday = birthday;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public @NotBlank String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank String phone) {
        this.phone = phone;
    }

    public @NotBlank String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank String address) {
        this.address = address;
    }

    public @NotBlank String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        this.city = city;
    }

    public @NotBlank String getPesel() {
        return pesel;
    }

    public void setPesel(@NotBlank String pesel) {
        this.pesel = pesel;
    }

    public @NotNull @ValidEnumMemberPattern(
            regexp = "MALE|FEMALE",
            message = "{gender.incorrect}",
            payload = Severity.Error.class) Gender getGender() {
        return gender;
    }

    public void setGender(@NotNull @ValidEnumMemberPattern(
            regexp = "MALE|FEMALE",
            message = "{gender.incorrect}",
            payload = Severity.Error.class) Gender gender) {
        this.gender = gender;
    }

    public List<Car> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Car> advertisements) {
        this.advertisements = advertisements;
    }
}
