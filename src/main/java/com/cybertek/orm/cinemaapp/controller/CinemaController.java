package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Cinema;
import com.cybertek.orm.cinemaapp.repository.CinemaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/name")
    public Cinema readByName(@RequestParam String name) {
        return cinemaRepository.findByName(name).orElse(null);
    }

    @GetMapping("/read-all")
    public List<Cinema> readAll() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/top/{sponsoredName}")
    public List<Cinema> readTopBySponsoredName(@PathVariable String sponsoredName) {
        return cinemaRepository.findFirst3BySponsoredNameContainingOrderBySponsoredNameAsc(sponsoredName);
    }

    @GetMapping("/location/{country}")
    public List<Cinema> readByLocationCountryName(@PathVariable String country) {
        return cinemaRepository.findAllByLocationCountry(country);
    }

    @GetMapping("/read")
    public List<Cinema> readAllNameOrSponsoredName(@RequestParam(required = false) String name, @RequestParam(required = false) String sponsoredName) {
        return cinemaRepository.findAllByNameOrSponsoredName(name, sponsoredName);
    }


}
