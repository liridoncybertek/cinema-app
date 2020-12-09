package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Integer countAllByUserId(Integer userId);

    List<Ticket> findAllByUserEmail(String email);

    /**
     * How many tickets are sold for a specific movie.
     * @param name
     * @return
     */
    Integer countAllByMovieCinemaMovieName(String name);

    /**
     * How many tickets are sold in a specific range.
     * @param firstDate
     * @param lastDate
     * @return
     */
    List<Ticket> findAllByDateTimeBetween(Date firstDate, Date lastDate);

}
