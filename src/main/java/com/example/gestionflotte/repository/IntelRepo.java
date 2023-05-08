package com.example.gestionflotte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestionflotte.model.Intelligence;

public interface IntelRepo extends JpaRepository <Intelligence , Integer> {
}
