package com.cinecity.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "shows")
public class Show implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private City city;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

    private long movie_id;

    private long price;

    public Show(long id, City city, Date start_date, Date end_date, long movie_id, long price) {
        this.id = id;
        this.city = city;
        this.start_date = start_date;
        this.end_date = end_date;
        this.movie_id = movie_id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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
