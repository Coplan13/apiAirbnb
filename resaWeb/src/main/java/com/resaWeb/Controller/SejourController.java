package com.resaWeb.Controller;

import com.resaWeb.Business.reservations.Sejour;
import com.resaWeb.Services.SejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sejour")
public class SejourController {

    @Autowired
    private SejourService sejourService;

    @GetMapping("/all")
    public List<Sejour> showAllSejour(){ return sejourService.getAllSejour();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sejour> showSejourById(@PathVariable Long id) {
        return sejourService.getSejourById(id);
    }
}
