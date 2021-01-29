package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Genre;
import com.cybertek.orm.cinemaapp.model.MovieCinema;
import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {

    //BASE URL
    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public WebFluxController(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }


    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllMovieCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Integer id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam("id") Integer id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    //IMAGINE LIKE THEY'RE CALLS FOR THIRD PARTY!!!!
    @PostMapping("create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
        Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);
    }

    @PutMapping("update-genre")
    public Mono<Genre> updateGenre(@RequestBody Genre genre) {
        Genre updatedGenre = genreRepository.save(genre);
        return Mono.just(updatedGenre);
    }

    @DeleteMapping("delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Integer id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }

//    ------------------------------- WEB CLIENT EXAMPLE -----------------------------

    @GetMapping("flux")
    public Flux<MovieCinema> readWithWebClient() {
        return webClient.get()
                .uri("/flux-movie-cinemas")
                .exchange()
                .flatMapMany(movieCinema -> movieCinema.bodyToFlux(MovieCinema.class));
    }


    @GetMapping("mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Integer id) {

        return webClient.get()
                .uri("/mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @GetMapping("mono-rp")
    public Mono<MovieCinema> readMonoWithWebClientRequestParam(@RequestParam("id") Integer id) {

        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/mono-movie-cinema")
                                .queryParam("id", id)
                                .build()
                )
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @PostMapping("create")
    public Mono<Genre> createWebClient(@RequestBody Genre genre) {
        return webClient.post()
                .uri("/create-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve()
                .bodyToMono(Genre.class);
    }

    @PutMapping("update")
    public Mono<Genre> updateWebClient(@RequestBody Genre genre) {
        return webClient.put()
                .uri("/update-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve()
                .bodyToMono(Genre.class);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteWebClient(@PathVariable("id") Integer id) {
        return webClient.delete()
                .uri("/delete-genre/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
