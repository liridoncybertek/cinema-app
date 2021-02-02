package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Cinema;
import com.cybertek.orm.cinemaapp.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
@Tag(name = "Cinema Controller", description = "Cinema API")
public class CinemaController {

    private final CinemaRepository cinemaRepository;


    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAll() {
        return cinemaRepository.findAll();
    }
 }
