package com.cybertek.orm.cinemaapp;

import com.cybertek.orm.cinemaapp.model.AccountDetails;
import com.cybertek.orm.cinemaapp.model.User;
import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class CinemaAppApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }


}
