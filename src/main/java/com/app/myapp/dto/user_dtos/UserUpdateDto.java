package com.app.myapp.dto.user_dtos;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserUpdateDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
}
