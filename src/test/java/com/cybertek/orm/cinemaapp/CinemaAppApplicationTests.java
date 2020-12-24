package com.cybertek.orm.cinemaapp;

import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import com.cybertek.orm.cinemaapp.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CinemaAppApplicationTests {

    @Autowired
    private AccountRepository accountRepository;
    @Test
    void contextLoads() {
    }


    @Test
    void accountDerivedQuery() {
        System.out.println("findAllByAgeBetween: " + accountRepository.findAllByAgeBetween(27,36));
        System.out.println("findAllByAgeLessThanEqual: " + accountRepository.findAllByAgeLessThanEqual(36));
        System.out.println("findByOrderByAgeAsc: " + accountRepository.findByOrderByAgeAsc());
        System.out.println("findByOrderByAgeAsc: " + accountRepository.findByOrderByAgeAsc());
        System.out.println("findAllByRole: " + accountRepository.findAllByRole(UserRole.ADMIN));
        System.out.println("findAllByCountryOrState: " + accountRepository.findAllByCountryOrState("United States", "Kentucky"));
        System.out.println("findByAddressStartingWith: " + accountRepository.findByAddressStartingWith("4161  Alfred"));
    }


}
