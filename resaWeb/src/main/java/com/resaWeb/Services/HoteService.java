package com.resaWeb.Services;

import com.resaWeb.Business.utilisateurs.Hote;
import com.resaWeb.Repository.HoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoteService {

    @Autowired
    private HoteRepository hoteRepository;

    public List<Hote> getAllHote(){
        return hoteRepository.findAll();
    }

    public ResponseEntity<Hote> getHoteById(Long idHote){

        Optional<Hote> hoteOptional = hoteRepository.findById(idHote);

        if (hoteOptional.isPresent())
        {
            return ResponseEntity.ok(hoteOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
