package com.example.gestionflotte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gestionflotte.model.Admin;
import com.example.gestionflotte.repository.AdminRepo;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/Admins")
@RestController
public class AdminController {

    @Autowired
    private AdminRepo adminrepo;

    private String message= "";

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @GetMapping
    public List<Admin> getAll(){
        return adminrepo.findAll();
    }

    @PostMapping
    public int authentification(@RequestBody Admin admin)
    {
        int id = Admin.auth(admin,adminrepo.findAll());
        if(id == 0)
        {
            setMessage("Authentification failed");
        }
        admin.setIdadmin(id);
        return id;
    }
}
