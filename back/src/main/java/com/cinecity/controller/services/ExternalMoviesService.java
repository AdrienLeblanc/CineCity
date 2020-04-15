package com.cinecity.controller.services;

import com.cinecity.entities.User;
import com.cinecity.entities.dto.Login;
import com.cinecity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@RestController
public class ExternalMoviesService {

    @Autowired
    private UserRepository userRepository;

    private final String apiKey = "1e3cf7552b75cb125158e15468ee6b46";

    @GetMapping("/cities")
    public Boolean getAllMovies(@Valid @RequestBody Login loginRequest) {

        HttpURLConnection con = null;
        try {
            URL url = new URL("http://example.com");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PutMapping("/movies/{movieId}")
    public Boolean getMovie(@PathVariable Long movieId) {
        Optional<User> queryResult = userRepository.findByLogin(loginRequest.getLogin());
        if (queryResult.isPresent()) {
            User user = queryResult.get();
            return user.getPassword().equals(loginRequest.getPassword());
        }
        return Boolean.FALSE;
    }
}
