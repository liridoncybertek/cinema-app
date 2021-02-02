package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Genre;
import com.cybertek.orm.cinemaapp.repository.GenreRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@Tag(name = "Genre Controller", description = "Genre API")
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Operation(summary = "Read all genres")
    @GetMapping
    public List<Genre> readAll() {
        return genreRepository.findAll();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Read by id")
    public Genre readById(@PathVariable Integer id) throws Exception {
        return genreRepository.findById(id).orElseThrow(() -> new Exception("Genre does not exists"));
    }

    @PostMapping
    @Operation(summary = "Create new genre")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping
    @Operation(summary = "Update an existing genre")
    public Genre update(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @Operation(summary = "Delete genre")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        Integer countGenres = genreRepository.countGenresNativeQuery(id);
        if (countGenres > 0) {
            throw new Exception("Genre can't be deleted, is linked by a movie");
        }
        genreRepository.deleteById(id);
    }
}
