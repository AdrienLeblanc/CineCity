package com.cinecity.entities.dto.movie.details;

import java.io.Serializable;

public class SpokenLanguages implements Serializable {

    private String iso_639_1;
    private String name;

    public SpokenLanguages() {
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
