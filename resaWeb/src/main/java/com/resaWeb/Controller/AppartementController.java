package com.resaWeb.Controller;

import com.resaWeb.Services.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbardu.resaBusiness.logements.Appartement;

import java.util.List;

@RestController
@RequestMapping("/appartement")
public class AppartementController {

    @Autowired
    private AppartementService appartementService;

    @GetMapping("/all")
    public List<Appartement> showAllAppartement(){
        return appartementService.getAllAppartement();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appartement> showAppartementById(@PathVariable Long id) {
        return appartementService.getAppartementById(id);
    }
}
