package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbardu.resaBusiness.reservations.SejourCourt;

public interface SejourCourtRepository extends JpaRepository<SejourCourt, Long> {
}
