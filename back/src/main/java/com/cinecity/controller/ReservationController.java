package com.cinecity.controller;

import com.cinecity.entities.Reservation;
import com.cinecity.exception.ResourceNotFoundException;
import com.cinecity.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping("/reservations")
    public Reservation createReservation(@Valid @RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/reservations/{reservationId}")
    public Reservation updateReservation(@PathVariable Long reservationId, @Valid @RequestBody Reservation reservationRequest) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservation.setId(reservationRequest.getId());
            reservation.setUser(reservationRequest.getUser());
            reservation.setShow(reservationRequest.getShow());
            reservation.setNbPlaces(reservationRequest.getNbPlaces());
            return reservationRepository.save(reservation);
        }).orElseThrow(() -> new ResourceNotFoundException("ReservationId " + reservationId + " not found"));
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long reservationId) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ReservationId " + reservationId + " not found"));
    }
}
