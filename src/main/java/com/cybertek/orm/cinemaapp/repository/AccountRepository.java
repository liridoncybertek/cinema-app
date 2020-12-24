package com.cybertek.orm.cinemaapp.repository;

import com.cybertek.orm.cinemaapp.model.AccountDetails;
import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Integer> {

    @Query(value = "SELECT * FROM account_details", nativeQuery = true)
    List<AccountDetails> fetchAll();

    //    ------------------DERIVED QUERIES--------------

    //Write a derived query to list all accounts with a specific country or state?
    List<AccountDetails> findAllByCountryOrState(String country, String state);

    //    Write a derived query to list all accounts with age lower than or equal to a specific value?
    List<AccountDetails> findAllByAgeLessThanEqual(Integer age);

    // Write a derived query to list all accounts with a specific role?
    List<AccountDetails> findAllByRole(UserRole role);

    // Write a derived query to list all accounts between a range of ages?
    List<AccountDetails> findAllByAgeBetween(Integer firstAge, Integer lastAge);

    //  Write a derived query to list all accounts where the beginning of the address contains the keyword?
    List<AccountDetails> findByAddressStartingWith(String address);

    // Write a derived query to sort the list of accounts with age?
    List<AccountDetails> findByOrderByAgeAsc();

    //    ------------------JPQL QUERIES--------------

    //    Write a JPQL query that returns all accounts?
    @Query("SELECT a from AccountDetails a")
    List<AccountDetails> fetchAllJPQL();

    //    Write a JPQL query to list all admin accounts?
    @Query("SELECT a from AccountDetails a WHERE a.role = 'ADMIN'")
    List<AccountDetails> fetchAdminUsers();

    //Write a JPQL query to sort all accounts with age?
    @Query("SELECT a from AccountDetails a")
    List<AccountDetails> orderWithAgeJPQL(Sort sort);

//    ------------------------------NATIVE QUERIES------------------------

    // Write a native query to read all accounts with an age lower than a specific age?
    @Query(value = "SELECT * FROM account_details where age < ?1", nativeQuery = true)
    List<AccountDetails> retrieveAllByAgeLowerThan(Integer age);

    //    Write a native query to read all accounts that a specific value can be containable in the name, address, country, state, city?
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat ('%', ?1, '%') OR country  ILIKE concat('%', ?1, '%') " +
            " OR address ILIKE concat('%', ?1, '%') OR city ILIKE concat('%', ?1, '%') OR state ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<AccountDetails> retrieveBySearchCriteria(String searchCriteria);

    //     Write a native query to read all accounts with an age lower than a specific age?
    @Query(value = "SELECT * FROM account_details ORDER BY age", nativeQuery = true)
    List<AccountDetails> orderByAgeNativeQuery();
}
