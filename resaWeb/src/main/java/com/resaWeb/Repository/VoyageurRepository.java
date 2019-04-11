package com.resaWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pbardu.resaBusiness.utilisateurs.Personne;
import pbardu.resaBusiness.utilisateurs.Voyageur;

import java.util.List;

public interface VoyageurRepository extends JpaRepository<Voyageur, Long> {

}
