package com.cinecity.controller.services;

import com.cinecity.entities.dto.movie.PopularMovies;
import com.cinecity.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

@RestController
public class ExternalMoviesService {

    @Autowired
    private UserRepository userRepository;

    private final String urlPopularMovies = "https://api.themoviedb.org/3/movie/popular";
    private final String apiKey = "1e3cf7552b75cb125158e15468ee6b46";

    @GetMapping("/movies/{pageId}")
    public PopularMovies getPopularMovies(@PathVariable Long pageId) {

        try {

            MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
            parameters.put("api_key", Collections.singletonList(apiKey));
            parameters.put("language", Collections.singletonList("fr-FR"));
            parameters.put("page", Collections.singletonList(String.valueOf(pageId)));

            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .scheme("https").host("api.themoviedb.org")
                    .path("/3/movie/popular")
                    .queryParams(parameters)
                    .build();

            URL url = new URL(uriComponents.toUriString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(RequestMethod.GET.name());
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            System.out.println(status);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            PopularMovies result = new ObjectMapper().readValue(in, PopularMovies.class);
            con.disconnect();

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
