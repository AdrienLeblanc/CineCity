package com.cinecity.controller.services;

import com.cinecity.controller.services.servicesUtils.HttpUtils;
import com.cinecity.entities.dto.movie.details.MovieDetails;
import com.cinecity.entities.dto.movie.multisearch.MultiSearch;
import com.cinecity.entities.dto.movie.popular.PopularResults;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ExternalMoviesService {

    private final String apiKey = "1e3cf7552b75cb125158e15468ee6b46";

    @GetMapping("/movies/popular/{pageId}")
    public PopularResults getPopularResults(@PathVariable Long pageId) {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.put("api_key", Collections.singletonList(apiKey));
        parameters.put("language", Collections.singletonList("fr-FR"));
        parameters.put("page", Collections.singletonList(String.valueOf(pageId)));

        return HttpUtils.httpGetBuilder("api.themoviedb.org", "/3/movie/popular", parameters, PopularResults.class);
    }

    @GetMapping("/movies/{movieId}/details")
    public MovieDetails getMovieDetails(@PathVariable Long movieId) {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.put("api_key", Collections.singletonList(apiKey));
        parameters.put("language", Collections.singletonList("fr-FR"));

        return HttpUtils.httpGetBuilder("api.themoviedb.org", "/3/movie/" + movieId, parameters, MovieDetails.class);
    }

    @GetMapping("/search/multi/{query}/{pageId}")
    public MultiSearch multiSearch(@PathVariable String query, @PathVariable String pageId) {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.put("api_key", Collections.singletonList(apiKey));
        parameters.put("language", Collections.singletonList("fr-FR"));
        parameters.put("query", Collections.singletonList(query));
        parameters.put("page", Collections.singletonList(String.valueOf(pageId)));

        return HttpUtils.httpGetBuilder("api.themoviedb.org", "/3/search/multi/", parameters, MultiSearch.class);
    }
}
