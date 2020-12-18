package com.cybertek.orm.cinemaapp.model;

import com.cybertek.orm.cinemaapp.model.enums.MovieState;
import com.cybertek.orm.cinemaapp.model.enums.MovieType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@ToString
public class Movie extends Model<Integer> {

    private String name;

    @Positive(message = "Price should be positive number")
    private BigDecimal price;

    @Column(name = "release_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre_rel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

    public Movie(String name, @Positive(message = "Price should be positive number") BigDecimal price, LocalDateTime releaseDate, Integer duration, MovieType type, MovieState state) {
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.type = type;
        this.state = state;
    }
}
