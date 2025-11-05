package com.example.aina.services;

import com.example.aina.dto.HairstyleDto;

import java.util.List;

public interface HairstyleService {


    //хаирстайл крид)
    List<HairstyleDto> getAllHairstyles();

    HairstyleDto getHairstyleById(Long id);

    HairstyleDto addHairstyle(HairstyleDto hairstyleDto);

    HairstyleDto updateHairstyle(Long id, HairstyleDto hairstyleDto);

    void deleteHairstyle(Long id);


    List<HairstyleDto> findByFaceShape(String faceShape);
    HairstyleDto updateImageUrl(Long id, String imageUrl);

}
