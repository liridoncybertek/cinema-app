package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Movie;
import com.cybertek.orm.cinemaapp.model.enums.MovieState;
import com.cybertek.orm.cinemaapp.model.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    Optional<Movie> findByName(String name);

    List<Movie> findAllByPriceBetween(BigDecimal firstPrice, BigDecimal lastPrice);

    List<Movie> findAllByDurationIn(List<Integer> durations);

    List<Movie> findAllByReleaseDateAfter(Date releaseDate);

    List<Movie> findAllByStateAndType(MovieState movieState, MovieType movieType);
}
