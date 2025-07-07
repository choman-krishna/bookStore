package com.crishna.bookStore.repo;

import com.crishna.bookStore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO:
 * Notes --> how to write query
 *
 * */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE LOWER(u.name) = LOWER(:name) ")
    public List<User> getByName(String name);

    @Query("SELECT u FROM User u JOIN UserDetails ud ON u.id = ud.id " +
            "WHERE LOWER(ud.address) = LOWER(:address) ")
    List<User> getByAddress(String address);
}

