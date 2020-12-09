package com.cybertek.orm.cinemaapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "location")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location extends Model<Integer>{

    @NotNull
    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String address;

    @Column(name = "postal_code")
    private Integer postalCode;

    private String country;

    private String city;

    private String state;
}
