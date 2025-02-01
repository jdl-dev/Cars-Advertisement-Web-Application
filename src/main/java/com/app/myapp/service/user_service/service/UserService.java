package com.app.myapp.service.user_service.service;

import com.app.myapp.dto.user_dtos.UserChangePasswordDto;
import com.app.myapp.dto.user_dtos.UserCreateDto;
import com.app.myapp.dto.user_dtos.UserResponseDto;
import com.app.myapp.dto.user_dtos.UserUpdateDto;

public interface UserService {
    //CREATE
    UserResponseDto saveUser(UserCreateDto userDto);

    //READ
    UserResponseDto getUserById(long id);

    UserResponseDto getUserByPesel(String pesel);

    //UPDATE
    UserResponseDto updateUser(long id, UserUpdateDto userDto);

    UserResponseDto changePassword(UserChangePasswordDto userChangePasswordDto);

    //DELETE
    UserResponseDto deleteUser(long id);
}
