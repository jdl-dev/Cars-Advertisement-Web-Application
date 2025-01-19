package com.app.myapp.controller.impl;

import com.app.myapp.controller.UserController;
import com.app.myapp.dto.UserDto;
import com.app.myapp.service.user_service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public UserDto addUser(@RequestBody @Valid UserDto userDto) {
        return userServiceImpl.addUser(userDto);
    }

    @Override
    @PutMapping("/updateUser/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody @Valid UserDto userDto) {
        return null;
    }

    @Override
    @GetMapping("/getUserById/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return null;
    }

    @Override
    @DeleteMapping("/deleteUserById/{id}")
    public UserDto deleteUser(@PathVariable int id) {
        return null;
    }
}
