package io.darrion.clientmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.add(client));
    }

    @PostMapping("/update") 
    public ResponseEntity<Object> update(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.add(client)); 
    }

    @PostMapping("/assignAdvisor")
    public ResponseEntity<Object> assign(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.add(client));
    }
    
}
