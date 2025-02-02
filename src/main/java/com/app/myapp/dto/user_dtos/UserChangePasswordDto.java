package com.app.myapp.dto.user_dtos;

import lombok.Getter;

@Getter
public class UserChangePasswordDto {
    private String oldPassword;
    private String newPassword;
}
