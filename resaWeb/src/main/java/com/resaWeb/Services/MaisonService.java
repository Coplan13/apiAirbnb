package com.resaWeb.Services;

import com.resaWeb.Repository.MaisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pbardu.resaBusiness.logements.Maison;

import java.util.List;
import java.util.Optional;

@Service
public class MaisonService {

    @Autowired
    private MaisonRepository maisonRepository;

    public List<Maison> getAllMaison(){
        return maisonRepository.findAll();
    }

    public ResponseEntity<Maison> getMaisonById(Long idMaison){

        Optional<Maison> maisonOptional = maisonRepository.findById(idMaison);

        if (maisonOptional.isPresent())
        {
            return ResponseEntity.ok(maisonOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
