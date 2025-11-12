package com.example.aina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userGender;
    private String userName;
    private String userEmail;
    private List<HairstyleDto> userHairstyles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<HairstyleDto> getUserHairstyles() {
        return userHairstyles;
    }

    public void setUserHairstyles(List<HairstyleDto> userHairstyles) {
        this.userHairstyles = userHairstyles;
    }
}
