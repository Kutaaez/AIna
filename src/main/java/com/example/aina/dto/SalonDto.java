package com.example.aina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalonDto {
    private Long id;
    private String salonName;
    private String location;
    private String phoneNumber;
    private List<HairstyleDto> hairstyles;

    public List<HairstyleDto> getHairstyles() {
        return hairstyles;
    }

    public void setHairstyles(List<HairstyleDto> hairstyles) {
        this.hairstyles = hairstyles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
