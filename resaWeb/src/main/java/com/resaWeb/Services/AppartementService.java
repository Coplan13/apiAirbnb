package com.resaWeb.Services;

import com.resaWeb.Business.logements.Appartement;
import com.resaWeb.Repository.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartementService {

    @Autowired
    private AppartementRepository appartementRepository;

    public List<Appartement> getAllAppartement(){
        return appartementRepository.findAll();
    }

    public ResponseEntity<Appartement> getAppartementById(Long idAppartement){

        Optional<Appartement> appartementOptional = appartementRepository.findById(idAppartement);

        if (appartementOptional.isPresent())
        {
            return ResponseEntity.ok(appartementOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
