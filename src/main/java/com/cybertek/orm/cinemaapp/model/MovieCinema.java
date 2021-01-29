package com.cybertek.orm.cinemaapp.model;

import com.cybertek.orm.cinemaapp.serializer.CinemaSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie_cinema")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class MovieCinema extends Model<Integer>{

//    @JsonSerialize(using = CinemaSerializer.class)
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
