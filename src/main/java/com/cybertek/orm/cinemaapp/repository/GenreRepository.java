package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Optional<Genre> findByName(String name);

}

