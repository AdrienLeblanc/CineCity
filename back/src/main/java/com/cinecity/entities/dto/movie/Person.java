package com.cinecity.entities.dto.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends MediaType {

    @JsonProperty("profile_path")
    private String profilePath;
    private Boolean adult;
    @JsonProperty("known_for")
    private CinematographicWork[] knownFor;

}
