package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findAllByAccountDetailsNameContaining(String name);

    List<User> findAllByAccountDetailsNameContainingIgnoreCase(String name);

    List<User> findAllByAccountDetailsAgeGreaterThan(Integer age);

}
