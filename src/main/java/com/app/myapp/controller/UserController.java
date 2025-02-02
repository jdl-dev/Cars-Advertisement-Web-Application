package com.app.myapp.controller;

import com.app.myapp.dto.user_dtos.PeselDto;
import com.app.myapp.dto.user_dtos.UserChangePasswordDto;
import com.app.myapp.dto.user_dtos.UserCreateDto;
import com.app.myapp.dto.user_dtos.UserResponseDto;
import com.app.myapp.dto.user_dtos.UserUpdateDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {
    UserResponseDto saveUser(UserCreateDto createUserDto);

    UserResponseDto updateUser(int id, UserUpdateDto updateUserDto);

    UserResponseDto changePassword(int id, UserChangePasswordDto changePasswordDto);

    UserResponseDto getUserById(int id);

    UserResponseDto getUserByPesel(PeselDto pesel);

    UserResponseDto deleteUser(int id);
}
