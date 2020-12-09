package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    Optional<Cinema> findByName(String name);

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredNameAsc(String sponsoredName);

    List<Cinema> findAllByLocationCountry(String country);

    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);

}
