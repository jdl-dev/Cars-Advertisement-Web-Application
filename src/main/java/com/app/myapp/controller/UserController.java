package com.app.myapp.controller;

import com.app.myapp.dto.UserDto;

public interface UserController {
    UserDto addUser(UserDto userDto);

    UserDto updateUser(int id, UserDto userDto);

    UserDto getUserById(int id);

    UserDto deleteUser(int id);
}
