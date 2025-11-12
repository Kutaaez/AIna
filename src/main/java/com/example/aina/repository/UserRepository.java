package com.example.aina.repository;

import com.example.aina.entities.Hairstyle;
import com.example.aina.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
