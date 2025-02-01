package com.app.myapp.controller.impl;

import com.app.myapp.controller.UserController;
import com.app.myapp.dto.user_dtos.UserChangePasswordDto;
import com.app.myapp.dto.user_dtos.UserCreateDto;
import com.app.myapp.dto.user_dtos.UserResponseDto;
import com.app.myapp.dto.user_dtos.UserUpdateDto;
import com.app.myapp.service.user_service.service.UserService;
import com.app.myapp.validation.validation.pesel_validation.UniquePesel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/createUser")
    public UserResponseDto saveUser(@Valid @RequestBody UserCreateDto createUserDto) {
        return userService
                .saveUser(createUserDto);
    }

    @Override
    @PutMapping("/updateUser/{id}")
    public UserResponseDto updateUser(@PathVariable int id, @Valid @RequestBody UserUpdateDto updateUserDto) {
        return userService.updateUser(id, updateUserDto);
    }

    @Override
    @PutMapping("/changePassword")
    public UserResponseDto changePassword(@RequestBody UserChangePasswordDto changePasswordDto) {
        return userService.changePassword(changePasswordDto);
    }

    @Override
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @Override
    @GetMapping("/userByPesel")
    public UserResponseDto getUserByPesel(@RequestParam @UniquePesel String pesel) {
        return userService.getUserByPesel(pesel);
    }

    @Override
    @DeleteMapping("/deleteUser/{id}")
    public UserResponseDto deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}