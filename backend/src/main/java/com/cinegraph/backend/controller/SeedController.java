package com.cinegraph.backend.controller;

import com.cinegraph.backend.service.SeedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeedController{

    private final SeedService seedService;

    public SeedController(SeedService seedService){
        this.seedService = seedService;
    }

    @PostMapping("/api/seed")
    public String seed(){
        return seedService.seedDatabase();
    }
}