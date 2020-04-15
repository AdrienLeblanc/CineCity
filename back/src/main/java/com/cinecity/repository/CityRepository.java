package com.cinecity.repository;

import com.cinecity.entities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}