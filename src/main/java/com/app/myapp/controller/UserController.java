package com.app.myapp.controller;

import com.app.myapp.dto.UserDto;

public interface UserController {
    UserDto addUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto getUserById(int id);

    UserDto deleteUser(int id);
}
