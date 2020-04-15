package com.cinecity.controller.services;

import com.cinecity.entities.dto.movie.PopularMovies;
import com.cinecity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class ExternalMoviesService {

    @Autowired
    private UserRepository userRepository;

    private final String url = "https://api.themoviedb.org/3/movie";
    private final String apiKey = "1e3cf7552b75cb125158e15468ee6b46";

    @GetMapping("/movies/{pageId}")
    public List<PopularMovies> getPopularMovies(@PathVariable Long pageId) {

        try {
            URL url = new URL(this.url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
