package com.cinegraph.backend.controller;

import com.cinegraph.backend.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController{

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public List<Map<String, Object>> getMovies(){
        return movieService.getMovies();
    }
}