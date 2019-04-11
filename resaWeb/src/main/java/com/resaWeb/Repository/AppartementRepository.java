package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbardu.resaBusiness.logements.Appartement;
import pbardu.resaBusiness.logements.AppartementDao;

import java.util.List;

public interface AppartementRepository extends JpaRepository<Appartement, Long>, AppartementDao {

}
