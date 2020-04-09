package com.cinecity.entities;

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

    private Date start_date;

    private Date end_date;

    private Long movie_id;

    private Long price;

    public Show() {
    }

    public Show(Long id, City city, Date start_date, Date end_date, Long movie_id, Long price) {
        this.id = id;
        this.city = city;
        this.start_date = start_date;
        this.end_date = end_date;
        this.movie_id = movie_id;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
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
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", movie_id=" + movie_id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return getMovie_id() == show.getMovie_id() &&
                getPrice() == show.getPrice() &&
                Objects.equals(getCity(), show.getCity()) &&
                Objects.equals(getStart_date(), show.getStart_date()) &&
                Objects.equals(getEnd_date(), show.getEnd_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStart_date(), getEnd_date(), getMovie_id(), getPrice());
    }
}
