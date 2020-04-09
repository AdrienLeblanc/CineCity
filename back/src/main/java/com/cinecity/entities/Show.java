package com.cinecity.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "city_id")
    private long city_id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "movie_id")
    private long movie_id;

    @Column(name = "price")
    private long price;

    public Show(long id, long city_id, Date start_date, Date end_date, long movie_id, long price) {
        this.id = id;
        this.city_id = city_id;
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

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
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
                ", city_id=" + city_id +
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
        return getCity_id() == show.getCity_id() &&
                getMovie_id() == show.getMovie_id() &&
                getPrice() == show.getPrice() &&
                Objects.equals(getStart_date(), show.getStart_date()) &&
                Objects.equals(getEnd_date(), show.getEnd_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity_id(), getStart_date(), getEnd_date(), getMovie_id(), getPrice());
    }
}
