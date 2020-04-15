package com.cinecity.entities.dto.movie;

import java.io.Serializable;

public class ProductionCompanies implements Serializable {

    private Long id;
    private String logoPath;
    private String name;
    private String originCountry;

    public ProductionCompanies() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
