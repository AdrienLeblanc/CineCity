package com.cinecity.repository;

import com.cinecity.entities.City;
import com.cinecity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}