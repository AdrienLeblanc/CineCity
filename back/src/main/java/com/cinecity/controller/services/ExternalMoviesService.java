package com.cinecity.controller.services;

import com.cinecity.controller.services.servicesUtils.HttpUtils;
import com.cinecity.entities.dto.movie.MovieDetails;
import com.cinecity.entities.dto.movie.PopularMovies;
import com.cinecity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ExternalMoviesService {

    @Autowired
    private UserRepository userRepository;

    private final String urlPopularMovies = "https://api.themoviedb.org/3/movie/popular";
    private final String apiKey = "1e3cf7552b75cb125158e15468ee6b46";

    @GetMapping("/movies/popular/{pageId}")
    public PopularMovies getPopularMovies(@PathVariable Long pageId) {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.put("api_key", Collections.singletonList(apiKey));
        parameters.put("language", Collections.singletonList("fr-FR"));
        parameters.put("page", Collections.singletonList(String.valueOf(pageId)));

        return HttpUtils.httpGetBuilder("api.themoviedb.org", "/3/movie/popular", parameters, PopularMovies.class);
    }

    @GetMapping("/movies/{movieId}/details")
    public MovieDetails getMovieDetails(@PathVariable Long movieId) {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.put("api_key", Collections.singletonList(apiKey));
        parameters.put("language", Collections.singletonList("fr-FR"));

        return HttpUtils.httpGetBuilder("api.themoviedb.org", "/3/movie/" + movieId, parameters, MovieDetails.class);
    }
}
