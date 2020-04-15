package com.cinecity.controller.services;

import com.cinecity.entities.model.User;
import com.cinecity.entities.dto.auth.Login;
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
    public Boolean authentification(@Valid @RequestBody Login loginRequest) {
        Optional<User> queryResult = userRepository.findByLogin(loginRequest.getLogin());
        if (queryResult.isPresent()) {
            User user = queryResult.get();
            return user.getPassword().equals(loginRequest.getPassword());
        }
        return Boolean.FALSE;
    }
}
