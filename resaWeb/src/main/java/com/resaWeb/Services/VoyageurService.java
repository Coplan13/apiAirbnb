package com.resaWeb.Services;

import com.resaWeb.Business.utilisateurs.Voyageur;
import com.resaWeb.Repository.VoyageurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class VoyageurService {


    @Autowired
    private VoyageurRepository voyageurRepository;

    public List<Voyageur> getAllVoyageur(){
        return voyageurRepository.findAll();
    }

    public ResponseEntity<Voyageur> getVoyageurById(Long idVoyageur){

        Optional<Voyageur> voyageurOptional = voyageurRepository.findById(idVoyageur);

        if (voyageurOptional.isPresent())
        {
            return ResponseEntity.ok(voyageurOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
