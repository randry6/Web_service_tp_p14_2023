package com.example.gestionflotte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestionflotte.execption.NotFoundException;
import com.example.gestionflotte.model.Intelligence;
import com.example.gestionflotte.repository.IntelRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping("/Intel")
@RestController
public class IntelControlleur {

    @Autowired
    private IntelRepo intel;

    @GetMapping
    public List<Intelligence> getAllIntel(){
        return intel.findAll();
    }

    @PostMapping("/NewIntel")
    public Intelligence NewIntel(@RequestBody Intelligence intelligence){
        return intel.save(intelligence);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intelligence> getById(@PathVariable int id){
        Intelligence intelli = intel.findById(id).orElseThrow(() -> new NotFoundException("Error"));
        return ResponseEntity.ok(intelli);
    }

    @PostMapping("Intel/{id}")
    public ResponseEntity<Intelligence> updateIntel(@PathVariable int id,@RequestBody Intelligence intelligence){

        Intelligence intels = intel.findById(id).orElseThrow(() -> new NotFoundException("Error"));
        intels.setApplications(intelligence.getApplications());
        intels.setDescriptions(intelligence.getDescriptions());
        intels.setTitre(intels.getTitre());

        Intelligence updateIntel = intel.save(intels);
        return ResponseEntity.ok(updateIntel);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteintel(@PathVariable int id){
        Intelligence intelligence = intel.findById(id).orElseThrow(() -> new NotFoundException("Error"));
        intel.delete(intelligence);
        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);


        return ResponseEntity.ok(response);
    }
}
