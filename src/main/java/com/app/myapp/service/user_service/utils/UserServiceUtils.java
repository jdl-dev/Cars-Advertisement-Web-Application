package com.app.myapp.service.user_service.utils;

import com.app.myapp.dto.user_dtos.UserUpdateDto;
import org.springframework.stereotype.Component;


public interface UserServiceUtils {
    boolean hasAtLeastOneNonNullProperty(UserUpdateDto userPropertiesToUpdateDto);
}
