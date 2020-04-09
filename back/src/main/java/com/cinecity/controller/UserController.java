package com.cinecity.controller;

import com.cinecity.entities.User;
import com.cinecity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/wines")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/saveWine")
    void saveWine(@RequestBody User wine) {
        userRepository.save(wine);
    }

    @PostMapping("/deleteWine")
    void deleteWine(@RequestBody User wine) {
        userRepository.delete(wine);
    }
}
