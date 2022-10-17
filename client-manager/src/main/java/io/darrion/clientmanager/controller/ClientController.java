package io.darrion.clientmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @PostMapping("/add")
    public ResponseEntity<Object> add() {
        return null; 
    }

    @PostMapping("/update") 
    public ResponseEntity<Object> update() {
        return null; 
    }

    
}
