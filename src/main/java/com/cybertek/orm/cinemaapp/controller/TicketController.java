package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.Ticket;
import com.cybertek.orm.cinemaapp.repository.TicketRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@Tag(name = "Ticket Controller", description = "Ticket API")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping
    @Operation(summary = "Read all tickets")
    public List<Ticket> readAll() {
        return ticketRepository.findAll();
    }
}
