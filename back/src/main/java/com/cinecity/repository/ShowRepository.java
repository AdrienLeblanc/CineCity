package com.cinecity.repository;

import com.cinecity.entities.Show;
import com.cinecity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {

}