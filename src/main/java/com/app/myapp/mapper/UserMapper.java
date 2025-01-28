package com.app.myapp.mapper;

import com.app.myapp.dto.UserDto;
import com.app.myapp.model.model.User;
import jakarta.validation.constraints.NotNull;

public class UserMapper {
    public static User toEntity(@NotNull UserDto userDto) {
        User user = new User();
    }

    public static UserDto toDto(@NotNull User user) {
        UserDto userDto = new UserDto();
    }
}
