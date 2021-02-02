package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.MovieCinema;
import com.cybertek.orm.cinemaapp.repository.MovieCinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie-cinema")
@Tag(name = "MovieCinema Controller", description = "MovieCinema API")
public class MovieCinemaController {

    private final MovieCinemaRepository movieCinemaRepository;

    public MovieCinemaController(MovieCinemaRepository movieCinemaRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @GetMapping
    @Operation(summary = "Read all movie cinemas")
    public List<MovieCinema> readAll() {
        return movieCinemaRepository.findAll();
    }
}
