package com.example.aina.mappers;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.entities.Hairstyle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SalonMapper.class)


public interface HairstyleMapper {
    HairstyleDto toDto(Hairstyle hairstyle);
    Hairstyle toEntity(HairstyleDto hairstyleDto);
    List<HairstyleDto> toDtoList(List<Hairstyle> hairstyles);

}
