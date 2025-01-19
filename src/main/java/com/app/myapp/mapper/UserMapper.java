package com.app.myapp.mapper;

import com.app.myapp.dto.UserDto;
import com.app.myapp.model.model.User;
import jakarta.validation.constraints.NotNull;

public class UserMapper {
    public static User toEntity(@NotNull UserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setBirthday(userDto.getBirthday());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setPesel(userDto.getPesel());
        user.setGender(userDto.getGender());
        user.setAdvertisements(userDto.getAdvertisements());

        return user;
    }

    public static UserDto toDto(@NotNull User user) {
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setSurname(user.getSurname());
        userDto.setUsername(user.getUsername());
        userDto.setBirthday(user.getBirthday());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setAddress(user.getAddress());
        userDto.setCity(user.getCity());
        userDto.setPesel(user.getPesel());
        userDto.setGender(user.getGender());
        userDto.setAdvertisements(user.getAdvertisements());

        return userDto;
    }
}
