package com.example.aina.services;

import com.example.aina.dto.SalonDto;

import java.util.List;

public interface    SalonService {
    //Салон крид))
    List<SalonDto> getAllSalons();

    SalonDto getSalonById(Long id);

    SalonDto saveSalon(SalonDto salonDto);

    SalonDto updateSalon(Long id, SalonDto salonDto);

    void deleteSalon(Long id);
}
