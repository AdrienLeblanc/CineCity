package com.cinecity.controller;

import com.cinecity.entities.User;
import com.cinecity.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private WineRepository wineRepository;

    @GetMapping("/wines")
    public List<User> findAll() {
        return wineRepository.findAll();
    }

    @PostMapping("/saveWine")
    void saveWine(@RequestBody User wine) {
        wineRepository.save(wine);
    }

    @PostMapping("/deleteWine")
    void deleteWine(@RequestBody User wine) {
        wineRepository.delete(wine);
    }
}
