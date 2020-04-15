package com.cinecity.controller.services;

import com.cinecity.entities.dto.auth.Login;
import com.cinecity.entities.model.User;
import com.cinecity.exception.IncorrectLoginException;
import com.cinecity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AuthentificationService {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/auth")
    public User authentification(@Valid @RequestBody Login loginRequest) {
        Optional<User> queryResult = userRepository.findByLogin(loginRequest.getLogin());
        if (queryResult.isPresent()) {
            return queryResult.get();
        } else {
            throw new IncorrectLoginException("Incorrect password for : " + loginRequest.getLogin());
        }
    }
}
