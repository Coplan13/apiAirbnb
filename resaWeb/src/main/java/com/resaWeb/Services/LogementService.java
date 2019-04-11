package com.resaWeb.Services;

import com.resaWeb.Business.logements.Logement;
import com.resaWeb.Repository.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LogementService {

    @Autowired
    private LogementRepository logementRepository;

    public List<Logement> getAllLogements(){
        return logementRepository.findAll();
    }

    public ResponseEntity<Logement> getLogmentById(Long idLogement){

        Optional<Logement> logementOptional = logementRepository.findById(idLogement);

        if (logementOptional.isPresent())
        {
            return ResponseEntity.ok(logementOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }

    }

    public List<Logement> getLogementByVille(String villeLogement){

        return logementRepository.findLogementsville(villeLogement);


    }
}
