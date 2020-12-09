package com.cybertek.orm.cinemaapp.controller;

import com.cybertek.orm.cinemaapp.model.User;
import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/email/{email}")
    public User readUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @GetMapping("/username/{username}")
    public User readUserByUserName(@PathVariable String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<User> readUserByAccountName(@PathVariable String name) {
        return userRepository.findAllByAccountDetailsNameContaining(name);
    }

    @GetMapping("/accName/{name}")
    public List<User> readUserByAccountNameIgnoreCase(@PathVariable String name) {
        return userRepository.findAllByAccountDetailsNameContainingIgnoreCase(name);
    }

    @GetMapping("/age/{age}")
    public List<User> readUserByAge(@PathVariable Integer age) {
        return userRepository.findAllByAccountDetailsAgeGreaterThan(age);
    }


}
