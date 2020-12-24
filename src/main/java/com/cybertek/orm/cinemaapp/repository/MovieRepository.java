package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Movie;
import com.cybertek.orm.cinemaapp.model.MovieCinema;
import com.cybertek.orm.cinemaapp.model.enums.MovieState;
import com.cybertek.orm.cinemaapp.model.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    -----------------------DERIVED QUERIES------------------------

    //     Write a derived query to read a movie with a name?
    Optional<Movie> findByName(String name);

    //    Write a derived query to list all movies between a range of prices?
    List<Movie> findAllByPriceBetween(BigDecimal firstPrice, BigDecimal lastPrice);

    // Write a derived query to list all movies where duration exists in the specific list of durations?
    List<Movie> findAllByDurationIn(List<Integer> durations);

    // Write a derived query to list all movies with higher than a specific release date?
    List<Movie> findAllByReleaseDateAfter(LocalDateTime releaseDate);

    //    Write a derived query to list all movies with a specific state and type?
    List<Movie> findAllByStateAndType(MovieState movieState, MovieType movieType);

//    --------------------------------------JPQL QUERIES---------------------------

    // Write a JPQL query to list all movies between a range of prices?
    @Query("SELECT m FROM Movie m  WHERE m.price BETWEEN ?1 AND ?2")
    List<MovieCinema> fetchAllBetweenPricesRange(BigDecimal startPrice, BigDecimal lastPrice);

    //Write a JPQL query that returns all movie names?
    @Query("SELECT DISTINCT m.name FROM Movie m")
    List<String> fetchAllMovieNames();

    //    ------------------------------------------NATIVE QUERIES----------------------

    //    Write a native query that returns a movie by name?
    @Query(value = "SELECT * FROM movie WHERE name = ?1", nativeQuery = true)
    Optional<Movie> retrieveByName(String name);

    //    Write a native query that returns the list of movies in a specific range of prices?
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> retrieveByPriceRange(BigDecimal first, BigDecimal last);

    //    Write a native query to return all movies where duration exists in the range of durations?
    @Query(value = "SELECT * FROM movie WHERE duration in ?1", nativeQuery = true)
    List<Movie> retrieveByDurationInRange(List<Integer> durations);

    //  Write a native query to list the top 5 most expensive movies?
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> top5ExpensiveMovies();




}
