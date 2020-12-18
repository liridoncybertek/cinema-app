package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Movie;
import com.cybertek.orm.cinemaapp.model.enums.MovieState;
import com.cybertek.orm.cinemaapp.model.enums.MovieType;
import com.cybertek.orm.cinemaapp.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/read/{name}")
    public Movie readByName(@PathVariable String name) {
        return movieRepository.findByName(name).orElse(null);
    }

    @GetMapping("/price-range")
    public List<Movie> readAllByPriceBetween(@RequestParam BigDecimal firstPrice, @RequestParam BigDecimal lastPrice) {
        return movieRepository.findAllByPriceBetween(firstPrice, lastPrice);
    }

    @GetMapping("/duration/{durations}")
    public List<Movie> readAllByDurationIn(@PathVariable List<Integer> durations) {
        return movieRepository.findAllByDurationIn(durations);
    }

    @GetMapping("/release-date/{date}")
    public List<Movie> readAllByReleaseDateAfter(@PathVariable String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime parseDateFromString  = LocalDateTime.parse(date, formatter);
        return movieRepository.findAllByReleaseDateAfter(parseDateFromString);
    }

    @GetMapping("/state-type")
    public List<Movie> readAllByStateAndType(@RequestParam MovieState state, @RequestParam MovieType type) {
        return movieRepository.findAllByStateAndType(state, type);
    }
}
