package com.example.aina.mappers;

import com.example.aina.dto.UserDto;
import com.example.aina.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = HairstyleMapper.class)
public interface UserMapper {

    @Mapping(source="gender",target="userGender")
    @Mapping(source="name",target="userName")
    @Mapping(source="email",target="userEmail")
    @Mapping(source = "hairstyles", target = "userHairstyles")
    UserDto toDto(User user);

    @Mapping(source="userGender",target="gender")
    @Mapping(source="userName",target="name")
    @Mapping(source="userEmail",target="email")
    @Mapping(source = "userHairstyles", target = "hairstyles")
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);
}
