package com.cinecity.repository;

import com.cinecity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(long id);

    User findByLogin(String login);

}