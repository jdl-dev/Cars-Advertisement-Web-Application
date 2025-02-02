package com.app.myapp.service.user_service.impl;

import com.app.myapp.dto.user_dtos.UserUpdateDto;
import com.app.myapp.service.user_service.utils.UserServiceUtils;

import java.util.Objects;
import java.util.stream.Stream;

public class UserServiceUtilsImpl implements UserServiceUtils {

    @Override
    public boolean hasAtLeastOneNonNullProperty(UserUpdateDto properties) {
        return Stream.of(
                        properties.getName(),
                        properties.getSurname(),
                        properties.getEmail(),
                        properties.getPhone(),
                        properties.getAddress(),
                        properties.getCity())
                .filter(Objects::nonNull)
                .count() > 0;
    }
}
