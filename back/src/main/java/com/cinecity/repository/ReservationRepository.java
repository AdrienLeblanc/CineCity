package com.cinecity.repository;

import com.cinecity.entities.Reservation;
import com.cinecity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}