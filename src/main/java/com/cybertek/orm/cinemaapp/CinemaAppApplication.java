package com.cybertek.orm.cinemaapp;

import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }

}
