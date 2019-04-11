package com.resaWeb.Repository;


import java.util.List;


import com.resaWeb.Business.utilisateurs.Hote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HoteRepository extends JpaRepository<Hote, Long> {


    @Query(value = "SELECT count(*) FROM Hote as h " +
            "INNER JOIN Logement as l " +
            "ON l.hote = h.id " +
            "WHERE age <=:ageHote " +
            "AND superficie >=:superficieLogement ")
    Integer findHotesLogement(@Param("ageHote") int ageHote, @Param("superficieLogement") int superficieLogement );

}
