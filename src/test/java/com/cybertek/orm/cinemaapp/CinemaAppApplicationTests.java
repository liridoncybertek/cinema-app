package com.cybertek.orm.cinemaapp;

import com.cybertek.orm.cinemaapp.model.AccountDetails;
import com.cybertek.orm.cinemaapp.model.User;
import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import com.cybertek.orm.cinemaapp.repository.CinemaRepository;
import com.cybertek.orm.cinemaapp.repository.TicketRepository;
import com.cybertek.orm.cinemaapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class CinemaAppApplicationTests {

<<<<<<< Updated upstream
    @Test
    void contextLoads() {
    }
=======
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void userExample() {
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setRole(UserRole.ADMIN);
        accountDetails.setCity("Prishtine");
        accountDetails.setPostalCode("Kosovo");
        accountDetails.setAge(27);
        accountDetails.setName("Liridon");
        accountDetails.setPostalCode("10000");
        accountDetails.setAddress("Str. Pjeter Bogdani");

        User user = new User();
        user.setEmail("email@email.com");
        user.setPassword("123123123");
        user.setUsername("liridon");
        user.setAccountDetails(accountDetails);

        AccountDetails accountDetails1 = new AccountDetails();
        accountDetails1.setRole(UserRole.ADMIN);
        accountDetails1.setCity("Prishtine");
        accountDetails1.setPostalCode("Kosovo");
        accountDetails1.setName("Donat");
        accountDetails1.setAge(29);
        accountDetails1.setPostalCode("10000");
        accountDetails1.setAddress("Str. Pjeter Bogdani");

        User user1 = new User();
        user1.setEmail("email2@email.com");
        user1.setPassword("123123123");
        user1.setUsername("donat");
        user1.setAccountDetails(accountDetails1);


        AccountDetails accountDetails2 = new AccountDetails();
        accountDetails2.setRole(UserRole.ADMIN);
        accountDetails2.setCity("Prishtine");
        accountDetails2.setPostalCode("Kosovo");
        accountDetails2.setName("Ozzy");
        accountDetails2.setAge(35);
        accountDetails2.setPostalCode("10000");
        accountDetails2.setAddress("Str. Pjeter Bogdani");

        User user2 = new User();
        user2.setEmail("email3@email.com");
        user2.setPassword("123123123");
        user2.setUsername("ozzy");
        user2.setAccountDetails(accountDetails2);

        userRepository.saveAll(Arrays.asList(user, user1, user2));


        final String email = "email@email.com";
        final String username = "donat";
        final String search = "don";

        System.out.println("find by username: " + userRepository.findByUsername(username));
        System.out.println("find by email: " + userRepository.findByEmail(email));
        System.out.println("find by name: " + userRepository.findAllByAccountDetailsNameContaining(search).toString());
        System.out.println("find by name ignore case: " + userRepository.findAllByAccountDetailsNameContainingIgnoreCase(search).toString());
        System.out.println("find by age greather than: " + userRepository.findAllByAccountDetailsAgeGreaterThan(30).toString());

    }
>>>>>>> Stashed changes

}
