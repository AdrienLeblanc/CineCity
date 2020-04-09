package com.cinecity.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    // https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
    private Show show;

    private Long nbPlaces;

    public Reservation() {
    }

    public Reservation(Long id, User user, Show show, Long nbPlaces) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.nbPlaces = nbPlaces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Long nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", show=" + show +
                ", nb_places=" + nbPlaces +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getNbPlaces() == that.getNbPlaces() &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getShow(), that.getShow());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getShow(), getNbPlaces());
    }
}
