package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pbardu.resaBusiness.reservations.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT l FROM Reservation l WHERE ID_VOYAGEUR =:idVoyageur")
    List<Reservation> findReservationsVoyageur(@Param("idVoyageur") int idVoyageur );
}
