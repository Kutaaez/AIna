package com.example.aina.repository;

import com.example.aina.entities.Hairstyle;
import com.example.aina.entities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {
}
