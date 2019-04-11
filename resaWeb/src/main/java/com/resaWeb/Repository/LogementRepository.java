package com.resaWeb.Repository;

import com.resaWeb.Business.logements.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface LogementRepository extends JpaRepository<Logement, Long>{

    @Query(value = "SELECT l FROM Logement l WHERE nbVoyageursMax >=:maxVoyageur")
    List<Logement> findByVoyageurMax(@Param("maxVoyageur") int maxVoyageur );

    @Query(value = "SELECT l FROM Logement l WHERE HOTE_ID >=:idHote")
    List<Logement> findLogementsHote(@Param("idHote") int idHote );

    @Query(value = "SELECT l FROM Logement l WHERE adresse LIKE CONCAT('%',:ville,'%')")
    List<Logement> findLogementsville(@Param("ville") String ville );




}
