package com.example.gestionflotte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestionflotte.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
