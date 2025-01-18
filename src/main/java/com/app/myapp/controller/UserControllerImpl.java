package com.app.myapp.controller;

import com.app.myapp.dto.UserDto;
import com.app.myapp.repository.UserRepository;
import com.app.myapp.service.user_service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserControllerImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    @PostMapping("/addUser")
    public UserDto addUser(UserDto userDto) {
        return userServiceImpl.addUser(userDto);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public UserDto deleteUser(int id) {
        return null;
    }
}
