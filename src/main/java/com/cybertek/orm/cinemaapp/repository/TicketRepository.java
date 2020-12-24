package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    //    ------------------------------ DERIVED QUERIES----------------------
    // Write a derived query to count how many tickets a user bought?
    Integer countAllByUserId(Integer userId);

    //    Write a derived query to list all tickets by a specific email?
    List<Ticket> findAllByUserEmail(String email);


    //    Write a derived query to count how many tickets are sold for a specific movie?
    Integer countAllByMovieCinemaMovieName(String name);

    //    Write a derived query to list all tickets between a range of dates?
    List<Ticket> findAllByDateTimeBetween(Date firstDate, Date lastDate);


//    ----------------------------------JPQL QUERIES------------------------

    //    Write a JPQL query that returns all tickets are bought from a specific user?
    @Query("SELECT t FROM Ticket t WHERE t.user.id = ?1")
    List<Ticket> fetchAllTicketsByUserJPQL(Integer userId);

    // Write a JPQL query that returns all tickets between a range of dates?
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllTicketsWithRangeDates(LocalDateTime start, LocalDateTime end);

    //    --------------------------------------NATIVE QUERIES-----------------------------

    //    Write a native query to count the number of tickets a user bought?
    @Query(value = "SELECT count(*) FROM ticket WHERE user_account_id = ?1", nativeQuery = true)
    Integer countTicketByUser(Integer userId);

    // Write a native query to count the number of tickets a user bought in a specific range of dates?
    @Query(value = "SELECT count(*) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countTicketByUserInADateRange(Integer userId, LocalDateTime start, LocalDateTime end);

    //    Write a native query to distinct all tickets by movie name?
    @Query(value = "SELECT DISTINCT(m.name) FROM ticket JOIN movie_cinema mc ON mc.id = ticket.movie_cinema_id JOIN movie m on mc.movie_id = m.id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieNames();

    //    Write a native query to find all tickets by user email?
    @Query(value = "SELECT * FROM ticket JOIN user_account ua on ticket.user_account_id = ua.id WHERE ua.email = ?1", nativeQuery = true)
    List<Ticket> retrieveAllByUserEmail(String email);

    //    Write a native query that returns all tickets?
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAll();

    //    Write a native query to list all tickets where a specific value should be containable in the username or name or movie name?
    @Query(value = "SELECT * FROM ticket JOIN user_account ua on ticket.user_account_id = ua.id " +
            " JOIN account_details ad on ad.id = ua.account_details_id " +
            " JOIN movie_cinema mc on ticket.movie_cinema_id = mc.id " +
            " JOIN movie m on mc.movie_id = m.id " +
            " WHERE ua.username ILIKE concat('%', ?1, '%') OR ad.name ILIKE concat('%', ?1, '%') OR m.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String searchCriteria);


}
