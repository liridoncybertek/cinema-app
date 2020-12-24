package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    //    ------------------------------DERIVED QUERIES----------------------

    //Write a derived query to read genre with the name?
    Optional<Genre> findByName(String name);

    //    ----------------------------- JPQL QUERIES -------------------------

    // Write a JPQL query that returns all genres?
    @Query("SELECT g FROM Genre g")
    List<Genre> fetchAllJPQL();

    //    ------------------------------- NATIVE QUERIES---------------------------

    //    Write a native query that returns genres by containing name?
    @Query(value = "SELECT * FROM genre WHERE name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> retrieveByName(String name);
}

