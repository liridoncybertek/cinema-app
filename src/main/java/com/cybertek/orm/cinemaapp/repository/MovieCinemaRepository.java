package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Integer> {

    @Override
    Optional<MovieCinema> findById(Integer integer);
}
