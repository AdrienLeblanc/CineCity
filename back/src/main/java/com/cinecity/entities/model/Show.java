package com.cinecity.entities.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "shows")
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private City city;

    private Date startDate;

    private Date endDate;

    private Long movieId;

    private Long price;

    public Show() {
    }

    public Show(Long id, City city, Date startDate, Date endDate, Long movieId, Long price) {
        this.id = id;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.movieId = movieId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", city=" + city +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                ", movie_id=" + movieId +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return getMovieId() == show.getMovieId() &&
                getPrice() == show.getPrice() &&
                Objects.equals(getCity(), show.getCity()) &&
                Objects.equals(getStartDate(), show.getStartDate()) &&
                Objects.equals(getEndDate(), show.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStartDate(), getEndDate(), getMovieId(), getPrice());
    }
}
