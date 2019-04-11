package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbardu.resaBusiness.logements.Maison;

public interface MaisonRepository extends JpaRepository<Maison, Long> {

}
