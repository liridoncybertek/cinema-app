package com.cybertek.orm.cinemaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cinema extends Model<Integer>{

    private String name;

    @Column(name = "sponsored_name")
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }
}
