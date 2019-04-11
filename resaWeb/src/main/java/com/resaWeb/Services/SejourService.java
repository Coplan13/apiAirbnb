package com.resaWeb.Services;

import com.resaWeb.Repository.SejourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pbardu.resaBusiness.reservations.Sejour;

import java.util.List;
import java.util.Optional;

@Service
public class SejourService {

    @Autowired
    private SejourRepository sejourRepository;

    public List<Sejour> getAllSejour(){
        return sejourRepository.findAll();
    }

    public ResponseEntity<Sejour> getSejourById(Long idSejour){

        Optional<Sejour> sejourOptional = sejourRepository.findById(idSejour);

        if (sejourOptional.isPresent())
        {
            return ResponseEntity.ok(sejourOptional.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
