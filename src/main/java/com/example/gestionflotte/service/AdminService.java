package com.example.gestionflotte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionflotte.model.Admin;
import com.example.gestionflotte.repository.AdminRepo;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo admin;

    public List<Admin> findAllAD(){
        return admin.findAll();
    }
}
