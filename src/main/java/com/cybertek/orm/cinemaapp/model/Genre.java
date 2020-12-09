package com.cybertek.orm.cinemaapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "genre")
public class Genre extends Model<Integer> {

    private String name;

    @ManyToMany(mappedBy = "genreList", fetch = FetchType.LAZY)
    private List<Movie> movies;
}
