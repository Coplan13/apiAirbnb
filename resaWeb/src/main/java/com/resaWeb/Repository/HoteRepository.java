package com.resaWeb.Repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pbardu.resaBusiness.logements.Logement;
import pbardu.resaBusiness.utilisateurs.Hote;
import pbardu.resaBusiness.utilisateurs.Personne;

public interface HoteRepository extends JpaRepository<Hote, Long> {


    @Query(value = "SELECT count(*) FROM Hote as h " +
            "INNER JOIN Logement as l " +
            "ON l.hote = h.id " +
            "WHERE age <=:ageHote " +
            "AND superficie >=:superficieLogement ")
    Integer findHotesLogement(@Param("ageHote") int ageHote, @Param("superficieLogement") int superficieLogement );

}
