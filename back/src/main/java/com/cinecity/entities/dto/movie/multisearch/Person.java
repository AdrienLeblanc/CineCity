package com.cinecity.entities.dto.movie.multisearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends MediaType {

    @JsonProperty("profile_path")
    private String profilePath;
    private Boolean adult;
    @JsonProperty("known_for")
    private CinematographicWork[] knownFor;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    private Long popularity;
    private Long gender;

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public CinematographicWork[] getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(CinematographicWork[] knownFor) {
        this.knownFor = knownFor;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }
}
