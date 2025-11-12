package com.example.aina.api;

import com.example.aina.dto.SalonDto;
import com.example.aina.services.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    // poluchit vse salony
    @GetMapping
    public List<SalonDto> getAllSalons() {
        return salonService.getAllSalons();
    }

    // poluchit salon po id
    @GetMapping("/{id}")
    public SalonDto getSalonById(@PathVariable Long id) {
        return salonService.getSalonById(id);
    }

    // dobavit novyy salon
    @PostMapping
    public SalonDto addSalon(@RequestBody SalonDto dto) {
        return salonService.saveSalon(dto);
    }

    // obnovit salon po id
    @PutMapping("/{id}")
    public SalonDto updateSalon(@PathVariable Long id, @RequestBody SalonDto dto) {
        return salonService.updateSalon(id, dto);
    }

    // udalit salon po id
    @DeleteMapping("/{id}")
    public void deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
    }
}
