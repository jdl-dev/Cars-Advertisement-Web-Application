package com.app.myapp.dto.user_dtos;

import com.app.myapp.model.model.Car;
import com.app.myapp.model.model.user_members.Gender;
import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@ToString
public class UserResponseDto {
    private long userId;
    private String name;
    private String username;
    private String surname;
    private LocalDate birthday;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String pesel;
    private Gender gender;
    private List<Car> advertisements;
}
