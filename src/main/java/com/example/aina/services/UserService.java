package com.example.aina.services;

import com.example.aina.dto.UserDto;

import java.util.List;

public interface UserService {

    //юзер крид))
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

}

