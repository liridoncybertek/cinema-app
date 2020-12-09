package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Ticket;
import com.cybertek.orm.cinemaapp.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/count-user/{userId}")
    public Integer countByUser(@PathVariable Integer userId) {
       return ticketRepository.countAllByUserId(userId);
    }

    @GetMapping("/email/{email}")
    public List<Ticket> readAllByUserEmail(@PathVariable  String email) {
        return ticketRepository.findAllByUserEmail(email);
    }

    @GetMapping("/count-movies/{name}")
    public Integer countMovies(@PathVariable String name) {
        return ticketRepository.countAllByMovieCinemaMovieName(name);
    }

    @GetMapping("/read-date")
    public List<Ticket> readAllByDateTimeBetween(@RequestParam String firstDate, @RequestParam String lastDate) throws ParseException {
        Date firstDateAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
        Date lastDateAsDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastDate);

        return ticketRepository.findAllByDateTimeBetween(firstDateAsDate, lastDateAsDate);
    }
}
