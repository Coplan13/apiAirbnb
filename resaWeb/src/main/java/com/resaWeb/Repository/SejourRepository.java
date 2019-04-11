package com.resaWeb.Repository;

import com.resaWeb.Business.reservations.Sejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SejourRepository  extends JpaRepository<Sejour, Long> {

    @Query(value = "SELECT s FROM Sejour s WHERE ID_LOGEMENT >=:idLogement")
    List<Sejour> findSejoursLogement(@Param("idLogement") int idLogement );
}
