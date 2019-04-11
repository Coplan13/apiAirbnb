package com.resaWeb.Repository;



import com.resaWeb.Business.logements.Appartement;
import com.resaWeb.Business.logements.AppartementDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppartementRepository extends JpaRepository<Appartement, Long>, AppartementDao {

}
