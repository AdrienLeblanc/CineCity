package com.cinecity.controller;

import com.cinecity.entities.Show;
import com.cinecity.exception.ResourceNotFoundException;
import com.cinecity.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;

    @GetMapping("/shows")
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @PostMapping("/shows")
    public Show createShow(@Valid @RequestBody Show show) {
        return showRepository.save(show);
    }

    @PutMapping("/shows/{showId}")
    public Show updateShow(@PathVariable Long showId, @Valid @RequestBody Show showRequest) {
        return showRepository.findById(showId).map(show -> {
            show.setId(showRequest.getId());
            show.setCity(showRequest.getCity());
            show.setStart_date(showRequest.getStart_date());
            show.setEnd_date(showRequest.getEnd_date());
            show.setMovie_id(showRequest.getMovie_id());
            show.setPrice(showRequest.getPrice());
            return showRepository.save(show);
        }).orElseThrow(() -> new ResourceNotFoundException("ShowId " + showId + " not found"));
    }

    @DeleteMapping("/shows/{showId}")
    public ResponseEntity<?> deleteShow(@PathVariable Long showId) {
        return showRepository.findById(showId).map(show -> {
            showRepository.delete(show);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ShowId " + showId + " not found"));
    }
}
