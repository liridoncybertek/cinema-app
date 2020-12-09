package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Genre;
import com.cybertek.orm.cinemaapp.repository.GenreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/read/{name}")
    public Genre readByName(@PathVariable String name) {
        return genreRepository.findByName(name).orElse(null);
    }
}
