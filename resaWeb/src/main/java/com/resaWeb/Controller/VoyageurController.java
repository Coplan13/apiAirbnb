package com.resaWeb.Controller;

import com.resaWeb.Services.VoyageurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbardu.resaBusiness.utilisateurs.Voyageur;

import java.util.List;

@RestController
@RequestMapping("/voyageurs")
public class VoyageurController {

    @Autowired
    private VoyageurService voyageurService;

    @GetMapping("")
    public List<Voyageur> showAllVoyageurs(){
        return voyageurService.getAllVoyageur();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voyageur> showVoyageurById(@PathVariable Long id) {
        return voyageurService.getVoyageurById(id);
    }
}
