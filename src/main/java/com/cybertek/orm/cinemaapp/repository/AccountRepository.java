package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Integer> {
}
