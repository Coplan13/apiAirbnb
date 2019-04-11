package com.resaWeb.Repository;



import com.resaWeb.Business.logements.Appartement;
import com.resaWeb.Business.logements.AppartementDao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppartementRepository extends JpaRepository<Appartement, Long>, AppartementDao {

}
