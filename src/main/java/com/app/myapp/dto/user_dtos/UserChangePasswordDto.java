package com.app.myapp.dto.user_dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserChangePasswordDto {
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;
}
