package com.app.myapp.service.user_service.impl;

import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.user_dtos.PeselDto;
import com.app.myapp.dto.user_dtos.UserChangePasswordDto;
import com.app.myapp.dto.user_dtos.UserCreateDto;
import com.app.myapp.dto.user_dtos.UserResponseDto;
import com.app.myapp.dto.user_dtos.UserUpdateDto;
import com.app.myapp.exception.other_purpose_exceptions.DatabaseConnectionException;
import com.app.myapp.exception.user_exceptions.PasswordDoesNotMuchException;
import com.app.myapp.exception.user_exceptions.UserInvalidException;
import com.app.myapp.exception.user_exceptions.UserNotFoundExceptions;
import com.app.myapp.mapper.UserMapper;
import com.app.myapp.model.model.User;
import com.app.myapp.repository.UserRepository;
import com.app.myapp.service.user_service.service.UserService;
import com.app.myapp.service.user_service.utils.UserServiceUtils;
import com.app.myapp.validation.validation.pesel_validation.UniquePesel;
import com.app.myapp.validation.validator.ObjectValidator;
import jakarta.validation.ConstraintViolation;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserServiceUtils userServiceUtils;
    private final PasswordEncoder passwordEncoder;
    private final ObjectValidator<UserCreateDto> userCreateDtoObjectValidator;
    private final ObjectValidator<UserUpdateDto> userUpdateDtoObjectValidator;
    private final ObjectValidator<PeselDto> userPeselDtoObjectValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserServiceUtils userServiceUtils, PasswordEncoder passwordEncoder, ObjectValidator<UserCreateDto> userCreateDtoObjectValidator, ObjectValidator<UserUpdateDto> userUpdateDtoObjectValidator, ObjectValidator<PeselDto> userPeselDtoObjectValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userServiceUtils = userServiceUtils;
        this.passwordEncoder = passwordEncoder;
        this.userCreateDtoObjectValidator = userCreateDtoObjectValidator;
        this.userUpdateDtoObjectValidator = userUpdateDtoObjectValidator;
        this.userPeselDtoObjectValidator = userPeselDtoObjectValidator;
    }

    @Override
    public UserResponseDto saveUser(UserCreateDto userDto) {
        userCreateDtoObjectValidator.validate(userDto);

        User userToBeSavedInDatabase =
                userMapper
                        .userCreateDtoToEntity(userDto);

        try {

            User savedUser =
                    userRepository
                            .save(userToBeSavedInDatabase);

            UserResponseDto savedUserMappedToUserResponseDto =
                    userMapper
                            .entityToUserResponseDto(savedUser);

            return savedUserMappedToUserResponseDto;
        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when saving user to database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while saving the user to database.");
        }
    }

    @Cacheable("userById")
    @Override
    public UserResponseDto getUserById(long id) {
        try {
            User userToBeRetrieved =
                    userRepository
                            .findById(id)
                            .orElseThrow(() -> new UserNotFoundExceptions("User with given id not found"));

            UserResponseDto retrievedUserFromDatabaseMappedToResponseDto =
                    userMapper
                            .entityToUserResponseDto(userToBeRetrieved);

            return retrievedUserFromDatabaseMappedToResponseDto;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when retrieving user by id from database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while retrieving the user by id from database.");
        }
    }

    @Cacheable("userByPesel")
    @Override
    public UserResponseDto getUserByPesel(PeselDto peselDto) {
        userPeselDtoObjectValidator.validate(peselDto);

        String pesel = peselDto.getPesel();

        try {
            User userToBeRetrieved =
                    userRepository
                            .findUserByPesel(pesel)
                            .orElseThrow(() -> new UserNotFoundExceptions("User with given pesel not found"));

            UserResponseDto retrievedUserFromDatabaseMappedToResponseDto =
                    userMapper
                            .entityToUserResponseDto(userToBeRetrieved);

            return retrievedUserFromDatabaseMappedToResponseDto;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when retrieving user by pesel from database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while retrieving the user by pesel from database.");
        }
    }


    @Override
    public UserResponseDto updateUser(long id, UserUpdateDto userPropertiesToUpdateDto) {
        userUpdateDtoObjectValidator.validate(userPropertiesToUpdateDto);

        try {
            User userToBeUpdated =
                    userRepository
                            .findById(id)
                            .orElseThrow(() -> new UserNotFoundExceptions("User with given id not found"));

            if (userPropertiesToUpdateDto == null) {
                throw new UserInvalidException("Updating user data is not correct.");
            }

            if (!userServiceUtils.hasAtLeastOneNonNullProperty(userPropertiesToUpdateDto)) {
                throw new UserInvalidException("No properties to update.");
            }


//            if (!userServiceUtils.isDateOfUpdatingTheAddValid(carPropertiesToUpdate)) {
//                throw new CarInvalidException("Date of updating advertisement is not correct.");
//            }

            //TODO

            return null;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when updating user in database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while updating user in database.");
        }
    }

    @Override
    public UserResponseDto changePassword(long id, UserChangePasswordDto userChangePasswordDto) {
        if (userChangePasswordDto == null) {
            throw new UserInvalidException("Passwords object is not correct.");
        }

        if (userChangePasswordDto.getNewPassword() == null || userChangePasswordDto.getOldPassword() == null) {
            throw new UserInvalidException("Passwords object is not correct.");
        }

        try {
            User userToChangePassword =
                    userRepository
                            .findById(id)
                            .orElseThrow(() -> new UserNotFoundExceptions("User with given id not found."));

            String oldRawPassword = userToChangePassword.getPassword();

            String oldRawPasswordToVerifyIfMatch = passwordEncoder.encode(userChangePasswordDto.getOldPassword());
            String newRawPassword = passwordEncoder.encode(userChangePasswordDto.getNewPassword());


            if (!oldRawPasswordToVerifyIfMatch.equals(oldRawPassword)) {
                throw new PasswordDoesNotMuchException(
                        "Old password doesn't much. Operation of changing password is interrupted.");
            }

            String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
            int minPasswordLengthInclusive = 8;

            if (!(newRawPassword.matches(passwordPattern) && newRawPassword.length() >= minPasswordLengthInclusive)) {
                throw new PasswordDoesNotMuchException(
                        "Password must be at least 8 characters long and " +
                                "must contain at least one letter, one number, and one special character\"");
            }

            userToChangePassword.setPassword(newRawPassword);

            UserResponseDto userWithChangedPassword =
                    userMapper
                            .entityToUserResponseDto(userToChangePassword);

            return userWithChangedPassword;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when changing user password.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while changing user password.");
        }

    }

    @Override
    public UserResponseDto deleteUser(long id) {
        try {
            User userToBeDeleted =
                    userRepository
                            .findById(id)
                            .orElseThrow(() -> new UserNotFoundExceptions("User with given id not found"));

            userRepository.deleteById(id);

            UserResponseDto userResponseDto = userMapper.entityToUserResponseDto(userToBeDeleted);

            return userResponseDto;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when changing user password.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while changing user password.");
        }
    }
}