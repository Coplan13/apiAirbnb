package com.resaWeb.Controller;

import com.resaWeb.Services.MaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pbardu.resaBusiness.logements.Maison;

import java.util.List;

@RestController
@RequestMapping("/maison")
public class MaisonController {

    @Autowired
    private MaisonService maisonService;

    @GetMapping("/all")
    public List<Maison> showAllMaison(){
        return maisonService.getAllMaison();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maison> showMaisonById(@PathVariable Long id) {
        return maisonService.getMaisonById(id);
    }

}
