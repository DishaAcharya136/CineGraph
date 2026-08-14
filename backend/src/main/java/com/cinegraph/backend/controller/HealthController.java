package com.cinegraph.backend.controller;

import com.cinegraph.backend.repository.CognoDBRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController{

    private final CognoDBRepository repository;

    public HealthController(CognoDBRepository repository){
        this.repository = repository;
    }

    @GetMapping("/api/health")
    public ResponseEntity<String> health(){
        try {
            return ResponseEntity.ok(repository.testConnection());
        } catch (Exception e){
            return ResponseEntity
                    .internalServerError()
                    .body("CognoDB connection failed");
        }
    }
}