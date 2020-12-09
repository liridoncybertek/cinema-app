package com.cybertek.orm.cinemaapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location extends Model<Integer> {

    @NotNull
    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
