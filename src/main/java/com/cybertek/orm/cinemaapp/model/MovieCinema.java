package com.cybertek.orm.cinemaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "movie_cinema")
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends Model<Integer>{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    public MovieCinema(Movie movie, Cinema cinema, LocalDateTime dateTime) {
        this.movie = movie;
        this.cinema = cinema;
        this.dateTime = dateTime;
    }
}
