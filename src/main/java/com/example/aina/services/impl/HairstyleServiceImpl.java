package com.example.aina.services.impl;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.entities.Hairstyle;
import com.example.aina.repository.HairstyleRepository;
import com.example.aina.services.HairstyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class HairstyleServiceImpl implements HairstyleService {
    private final HairstyleRepository hRep;

    @Override
    public List<HairstyleDto> getAllHairstyles() {
        List<Hairstyle> hairstyles = hRep.findAll();
        List<HairstyleDto> result = new ArrayList<>();
        for (Hairstyle hair : hairstyles) {
            result.add(convertToDto(hair));
        }
        return result;    }

    @Override
    public HairstyleDto getHairstyleById(Long id) {
        return null;
    }

    @Override
    public HairstyleDto addHairstyle(HairstyleDto hairstyleDto) {
        return null;
    }

    @Override
    public HairstyleDto updateHairstyle(Long id, HairstyleDto hairstyleDto) {
        return null;
    }

    @Override
    public void deleteHairstyle(Long id) {

    }

    @Override
    public List<HairstyleDto> findByFaceShape(String faceShape) {
        return List.of();
    }

    @Override
    public HairstyleDto updateImageUrl(Long id, String imageUrl) {
        return null;
    }

    private HairstyleDto convertToDto(Hairstyle hair) {
        HairstyleDto dto = new HairstyleDto();
        dto.setId(hair.getId());
        dto.setStyleName(hair.getStyleName());
        dto.setFaceShape(hair.getFaceShape());
        dto.setHairType(hair.getHairType());
        dto.setImageUrl(hair.getImageUrl());
        return dto;
    }

    private Hairstyle convertToEntity(HairstyleDto dto) {
        Hairstyle hair = new Hairstyle();
        hair.setId(dto.getId());
        hair.setStyleName(dto.getStyleName());
        hair.setFaceShape(dto.getFaceShape());
        hair.setHairType(dto.getHairType());
        hair.setImageUrl(dto.getImageUrl());
        return hair;
    }
}
