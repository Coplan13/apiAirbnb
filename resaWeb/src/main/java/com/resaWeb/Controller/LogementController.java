package com.resaWeb.Controller;

import com.resaWeb.Business.logements.Logement;
import com.resaWeb.Services.LogementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("logements")
public class LogementController {


    @Autowired
    private LogementService logementService;

    @RequestMapping
    public List<Logement> ShowLogementByVille(@RequestParam("ville") String ville, Model map
                                              ) {
        map.addAttribute("msg", "employees request by ville: " + ville);
        return logementService.getLogementByVille(ville);
    }

    @GetMapping("/*")
    public List<Logement> showAllLogements(){
        return logementService.getAllLogements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logement> showLogementById(@PathVariable Long id) {
        return logementService.getLogmentById(id);
    }



}


