package com.cinecity.entities.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String postalCode;

    private String country;

    public City() {
    }

    public City(Long id, String name, String postalCode, String country) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postal_code='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getName(), city.getName()) &&
                Objects.equals(getPostalCode(), city.getPostalCode()) &&
                Objects.equals(getCountry(), city.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPostalCode(), getCountry());
    }
}
