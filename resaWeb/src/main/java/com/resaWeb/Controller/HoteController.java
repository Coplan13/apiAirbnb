package com.resaWeb.Controller;

import com.resaWeb.Services.HoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pbardu.resaBusiness.utilisateurs.Hote;

import java.util.List;


@RestController
@RequestMapping("/hotes")
public class HoteController {

    @Autowired
    private HoteService hoteService;


    @GetMapping("")
    public List<Hote> showAllHote(){
        return hoteService.getAllHote();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hote> showHoteById(@PathVariable Long id) {
        return hoteService.getHoteById(id);
    }
}
