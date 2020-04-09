package com.cinecity.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "show_id")
    private long show_id;

    @Column(name = "nb_places")
    private long nb_places;

    public Reservation(long id, long user_id, long show_id, long nb_places) {
        this.id = id;
        this.user_id = user_id;
        this.show_id = show_id;
        this.nb_places = nb_places;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getShow_id() {
        return show_id;
    }

    public void setShow_id(long show_id) {
        this.show_id = show_id;
    }

    public long getNb_places() {
        return nb_places;
    }

    public void setNb_places(long nb_places) {
        this.nb_places = nb_places;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", show_id=" + show_id +
                ", nb_places=" + nb_places +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getUser_id() == that.getUser_id() &&
                getShow_id() == that.getShow_id() &&
                getNb_places() == that.getNb_places();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getShow_id(), getNb_places());
    }
}
