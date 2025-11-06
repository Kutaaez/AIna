package com.example.aina.api;

import com.example.aina.dto.HairstyleDto;
import com.example.aina.services.HairstyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hairstyles")
@RequiredArgsConstructor
public class HairstyleController {

    private final HairstyleService hairstyleService;


    //poluchit
    @GetMapping
    public List<HairstyleDto> getAllHairstyles() {
        return hairstyleService.getAllHairstyles();
    }
    //poluchit po id
    @GetMapping("/{id}")
    public HairstyleDto getHairstyleById(@PathVariable Long id) {
        return hairstyleService.getHairstyleById(id);
    }
    //dobavid
    @PostMapping
    public HairstyleDto addHairstyle(@RequestBody HairstyleDto dto) {
        return hairstyleService.addHairstyle(dto);
    }
    //obnovit
    @PutMapping("/{id}")
    public HairstyleDto updateHairstyle(@PathVariable Long id,
                                        @RequestBody HairstyleDto dto) {
        return hairstyleService.updateHairstyle(id, dto);
    }
    //udalit
    @DeleteMapping("/{id}")
    public void deleteHairstyle(@PathVariable Long id) {
        hairstyleService.deleteHairstyle(id);
    }
    //naiti
    @GetMapping("/search")
    public List<HairstyleDto> findByFaceShape(@RequestParam String faceShape) {
        return hairstyleService.findByFaceShape(faceShape);
    }
}
