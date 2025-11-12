package com.example.aina.services.impl;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.dto.SalonDto;
import com.example.aina.entities.Hairstyle;
import com.example.aina.entities.Salon;
import com.example.aina.mappers.HairstyleMapper;
import com.example.aina.mappers.SalonMapper;
import com.example.aina.repository.SalonRepository;
import com.example.aina.services.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository sRep;
    private final SalonMapper sMap;
    private final HairstyleMapper hMap;

    @Override
    public List<SalonDto> getAllSalons() {
        List<Salon> salons = sRep.findAll();
        List<SalonDto> result = new ArrayList<>();
        for (Salon s : salons) {
            result.add(sMap.toDto(s));
        }
        return result;
    }

    @Override
    public SalonDto getSalonById(Long id) {
        Salon salon = sRep.findById(id).orElse(null);
        if (salon == null) return null;
        return sMap.toDto(salon);
    }

    @Override
    public SalonDto saveSalon(SalonDto dto) {
        Salon salon = sMap.toEntity(dto);

        if (dto.getHairstyles() != null) {
            salon.setHairstyles(new ArrayList<>());
            for (HairstyleDto hDto : dto.getHairstyles()) {
                salon.getHairstyles().add(hMap.toEntity(hDto));
            }
        }

        Salon saved = sRep.save(salon);
        return sMap.toDto(saved);
    }

    @Override
    public SalonDto updateSalon(Long id, SalonDto dto) {
        Salon salon = sRep.findById(id).orElse(null);
        if (salon == null) return null;

        salon.setSalonName(dto.getSalonName());
        salon.setLocation(dto.getLocation());
        salon.setPhoneNumber(dto.getPhoneNumber());

        if (dto.getHairstyles() != null) {
            salon.setHairstyles(new ArrayList<>());
            for (HairstyleDto hDto : dto.getHairstyles()) {
                salon.getHairstyles().add(hMap.toEntity(hDto));
            }
        }

        Salon updated = sRep.save(salon);
        return sMap.toDto(updated);
    }

    @Override
    public void deleteSalon(Long id) {
        sRep.deleteById(id);
    }
}
