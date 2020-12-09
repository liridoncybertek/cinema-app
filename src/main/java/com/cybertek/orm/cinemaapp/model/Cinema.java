package com.cybertek.orm.cinemaapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
@Getter
@Setter
public class Cinema extends Model<Integer> {

    private String name;

    @Column(name = "sponsored_name")
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}
