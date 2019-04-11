package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pbardu.resaBusiness.logements.Logement;
import pbardu.resaBusiness.reservations.Sejour;

import java.util.List;

public interface SejourRepository  extends JpaRepository<Sejour, Long> {

    @Query(value = "SELECT s FROM Sejour s WHERE ID_LOGEMENT >=:idLogement")
    List<Sejour> findSejoursLogement(@Param("idLogement") int idLogement );
}
