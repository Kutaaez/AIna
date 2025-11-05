package com.example.aina.repository;
import java.util.List;

import com.example.aina.entities.Hairstyle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HairstyleRepository extends JpaRepository<Hairstyle, Long> {
    List<Hairstyle> findByFaceShape(String faceShape);
}
