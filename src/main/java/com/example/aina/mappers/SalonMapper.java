package com.example.aina.mappers;
import com.example.aina.dto.HairstyleDto;
import com.example.aina.dto.SalonDto;
import com.example.aina.entities.Hairstyle;
import com.example.aina.entities.Salon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = HairstyleMapper.class)
public interface SalonMapper {
    SalonDto toDto(Salon salon);
    Salon toEntity(SalonDto salonDto);
    List<SalonDto> toDtoList(List<Salon> salons);
}
