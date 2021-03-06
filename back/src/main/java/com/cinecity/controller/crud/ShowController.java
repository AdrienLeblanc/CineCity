package com.cinecity.controller.crud;

import com.cinecity.entities.model.Show;
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

    @GetMapping("/shows/{movieId}")
    public List<Show> searchForMovie(@PathVariable Long movieId) {
        return showRepository.findByMovieId(movieId);
    }

    @PostMapping("/shows")
    public Show createShow(@Valid @RequestBody Show show) {
        return showRepository.save(show);
    }

    @PutMapping("/shows/{showId}")
    public Show updateShow(@PathVariable Long showId, @Valid @RequestBody Show showRequest) {
        return showRepository.findById(showId).map(show -> {
            show.setCity(showRequest.getCity());
            show.setStartDate(showRequest.getStartDate());
            show.setEndDate(showRequest.getEndDate());
            show.setMovieId(showRequest.getMovieId());
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
