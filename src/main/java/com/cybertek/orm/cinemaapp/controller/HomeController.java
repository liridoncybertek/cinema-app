package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.*;
import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final MovieRepository movieRepository;

    private final MovieCinemaRepository movieCinemaRepository;

    private final CinemaRepository cinemaRepository;

    private final GenreRepository genreRepository;

    private final AccountRepository accountRepository;

    public HomeController(UserRepository userRepository, TicketRepository ticketRepository,
                          MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository,
                          CinemaRepository cinemaRepository, GenreRepository genreRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.accountRepository = accountRepository;
    }


    @GetMapping("/users")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/account-details")
    public List<AccountDetails> readAllAccountDetails() {
        return accountRepository.findAll();
    }

    @GetMapping("genres")
    public List<Genre> readAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("movies")
    public List<Movie> readAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("cinemas")
    public List<Cinema> readAllCinemas() {
        return cinemaRepository.findAll();
    }

    @GetMapping("movie-cinemas")
    public List<MovieCinema> readAllMovieCinemas() {
        return movieCinemaRepository.findAll();
    }

    @GetMapping("tickets")
    public List<Ticket> readAllTickets() {
        return ticketRepository.findAll();
    }
}
