package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Movie;
import com.cybertek.orm.cinemaapp.repository.MovieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@Tag(name = "Movie Controller", description = "Movie API")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    @Operation(summary = "Read all movies")
    public List<Movie> readAll() {
        return movieRepository.findAll();
    }
}
