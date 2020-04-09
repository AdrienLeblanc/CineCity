package com.cinecity.repository;

import com.cinecity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(long id);

    List<User> findByAppellation(String appellation);

    List<User> findByNomChateau(String nomChateau);

    List<User> findByType(String type);

    List<User> findByMillesime(long millesime);

    List<User> findByNbBouteillesAchetees(long nbBouteillesAchetees);

    List<User> findByDestockage(long destockage);

    List<User> findByNbBouteillesStock(long nbBouteillesStock);
}