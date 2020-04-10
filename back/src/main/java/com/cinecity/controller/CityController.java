package com.cinecity.controller;

import com.cinecity.entities.City;
import com.cinecity.exception.ResourceNotFoundException;
import com.cinecity.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCitys() {
        return cityRepository.findAll();
    }

    @PostMapping("/cities")
    public City createCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }

    @PutMapping("/cities/{cityId}")
    public City updateCity(@PathVariable Long cityId, @Valid @RequestBody City cityRequest) {
        return cityRepository.findById(cityId).map(city -> {
            city.setName(cityRequest.getName());
            city.setPostalCode(cityRequest.getPostalCode());
            city.setCountry(cityRequest.getCountry());
            return cityRepository.save(city);
        }).orElseThrow(() -> new ResourceNotFoundException("CityId " + cityId + " not found"));
    }

    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityId) {
        return cityRepository.findById(cityId).map(city -> {
            cityRepository.delete(city);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CityId " + cityId + " not found"));
    }
}
