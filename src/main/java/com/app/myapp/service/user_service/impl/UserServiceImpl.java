package com.app.myapp.service.user_service.impl;

import com.app.myapp.dto.UserDto;
import com.app.myapp.mapper.CarMapper;
import com.app.myapp.repository.UserRepository;
import com.app.myapp.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarMapper carMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CarMapper carMapper) {
        this.userRepository = userRepository;
        this.carMapper = carMapper;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return null;
    }
}
