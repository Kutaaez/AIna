package com.example.aina.services.impl;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.services.HairstyleService;

import java.util.List;

public class HairstyleServiceImpl implements HairstyleService {
    @Override
    public List<HairstyleDto> getAllHairstyles() {
        return List.of();
    }

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
}
