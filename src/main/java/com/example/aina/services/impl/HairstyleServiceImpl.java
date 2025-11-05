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
        return result;
    }

    @Override
    public HairstyleDto getHairstyleById(Long id) {
        Hairstyle hairstyle = hRep.findById(id).orElse(null);
        if (hairstyle != null) {
            return convertToDto(hairstyle);
        }
        return null;
    }

    @Override
    public HairstyleDto addHairstyle(HairstyleDto hairstyleDto) {
        Hairstyle hairstyle = convertToEntity(hairstyleDto);
        Hairstyle saved = hRep.save(hairstyle);
        return convertToDto(saved);
    }

    @Override
    public HairstyleDto updateHairstyle(Long id, HairstyleDto hairstyleDto) {
        Hairstyle existing = hRep.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setStyleName(hairstyleDto.getStyleName());
        existing.setFaceShape(hairstyleDto.getFaceShape());
        existing.setHairType(hairstyleDto.getHairType());
        existing.setImageUrl(hairstyleDto.getImageUrl());

        Hairstyle updated = hRep.save(existing);
        return convertToDto(updated) ;
    }

    @Override
    public void deleteHairstyle(Long id) {
        hRep.deleteById(id);

    }

    @Override
    public List<HairstyleDto> findByFaceShape(String faceShape) {
        List<Hairstyle> hairstyles = hRep.findByFaceShape(faceShape);
        List<HairstyleDto> result = new ArrayList<>();
        for (Hairstyle hair : hairstyles) {
            result.add(convertToDto(hair));
        }
        return result;    }

    @Override
    public HairstyleDto updateImageUrl(Long id, String imageUrl) {
        Hairstyle existing = hRep.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setImageUrl(imageUrl);

        Hairstyle updated = hRep.save(existing);
        return convertToDto(updated);    }

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
