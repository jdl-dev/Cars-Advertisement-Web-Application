package com.app.myapp.mapper;

import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.user_dtos.UserCreateDto;
import com.app.myapp.dto.user_dtos.UserResponseDto;
import com.app.myapp.model.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User userCreateDtoToEntity(UserCreateDto userCreateDto) {
        return User
                .builder()
                .name(userCreateDto.getName())
                .surname(userCreateDto.getSurname())
                .username(userCreateDto.getUsername())
                .birthday(userCreateDto.getBirthday())
                .email(userCreateDto.getEmail())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .phone(userCreateDto.getPhone())
                .address(userCreateDto.getAddress())
                .city(userCreateDto.getCity())
                .pesel(userCreateDto.getPesel())
                .gender(userCreateDto.getGender())
                .build();
    }

    public UserResponseDto entityToUserResponseDto(User user) {
        return UserResponseDto
                .builder()
                .name(user.getName())
                .surname(user.getSurname())
                .username(user.getUsername())
                .birthday(user.getBirthday())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .city(user.getCity())
                .pesel(user.getPesel())
                .gender(user.getGender())
                .advertisements(user.getAdvertisements())
                .build();
    }
}
