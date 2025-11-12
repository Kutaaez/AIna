package com.example.aina.services.impl;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.entities.Hairstyle;
import com.example.aina.mappers.HairstyleMapper;
import com.example.aina.repository.HairstyleRepository;
import com.example.aina.services.HairstyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HairstyleServiceImpl implements HairstyleService {

    private final HairstyleRepository hRep;
    private final HairstyleMapper hMap;

    @Override
    public List<HairstyleDto> getAllHairstyles() {
        List<Hairstyle> hairstyles = hRep.findAll();
        List<HairstyleDto> result = new ArrayList<>();
        for (Hairstyle h : hairstyles) {
            result.add(hMap.toDto(h));
        }
        return result;
    }

    @Override
    public HairstyleDto getHairstyleById(Long id) {
        Hairstyle hair = hRep.findById(id).orElse(null);
        if (hair == null) return null;
        return hMap.toDto(hair);
    }

    @Override
    public HairstyleDto addHairstyle(HairstyleDto dto) {
        Hairstyle hair = hMap.toEntity(dto);
        hair.setCreatedAt(LocalDateTime.now());
        Hairstyle saved = hRep.save(hair);
        return hMap.toDto(saved);
    }

    @Override
    public HairstyleDto updateHairstyle(Long id, HairstyleDto dto) {
        Hairstyle hair = hRep.findById(id).orElse(null);
        if (hair == null) return null;

        hair.setStyleName(dto.getStyleName());
        hair.setFaceShape(dto.getFaceShape());
        hair.setHairType(dto.getHairType());
        hair.setImageUrl(dto.getImageUrl());
        hair.setUpdatedAt(LocalDateTime.now());

        Hairstyle updated = hRep.save(hair);
        return hMap.toDto(updated);
    }

    @Override
    public void deleteHairstyle(Long id) {
        hRep.deleteById(id);
    }

    @Override
    public List<HairstyleDto> findByFaceShape(String faceShape) {
        List<Hairstyle> hairstyles = hRep.findByFaceShape(faceShape);
        List<HairstyleDto> result = new ArrayList<>();
        for (Hairstyle h : hairstyles) {
            result.add(hMap.toDto(h));
        }
        return result;
    }
}
