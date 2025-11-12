package com.example.aina.services.impl;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.dto.UserDto;
import com.example.aina.entities.User;
import com.example.aina.mappers.HairstyleMapper;
import com.example.aina.mappers.UserMapper;
import com.example.aina.repository.HairstyleRepository;
import com.example.aina.repository.UserRepository;
import com.example.aina.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {


    private final UserRepository uRep;
    private final UserMapper uMap;
    private final HairstyleMapper hMap;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = uRep.findAll();
        List<UserDto> result = new ArrayList<>();
        for (User u : users) {
            result.add(uMap.toDto(u));
        }
        return result;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = uRep.findById(id).orElse(null);
        if (user == null) return null;
        return uMap.toDto(user);
    }

    @Override
    public UserDto saveUser(UserDto dto) {
        User user = uMap.toEntity(dto);
        User saved = uRep.save(user);
        return uMap.toDto(saved);
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User user = uRep.findById(id).orElse(null);
        if (user == null) return null;

        user.setName(dto.getUserName());
        user.setEmail(dto.getUserEmail());
        user.setGender(dto.getUserGender());

        if (dto.getUserHairstyles() != null) {
            user.setHairstyles(new ArrayList<>());
            for (HairstyleDto hDto : dto.getUserHairstyles()) {
                user.getHairstyles().add(hMap.toEntity(hDto));
            }
        }

        User updated = uRep.save(user);
        return uMap.toDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        uRep.deleteById(id);
    }

}
