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

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @Column(name = "nb_places")
    private long nb_places;

    public Reservation(long id, User user, Show show, long nb_places) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.nb_places = nb_places;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
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
                ", user=" + user +
                ", show=" + show +
                ", nb_places=" + nb_places +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getNb_places() == that.getNb_places() &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getShow(), that.getShow());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getShow(), getNb_places());
    }
}
