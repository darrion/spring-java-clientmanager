package io.darrion.clientmanager.controller;

import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.ClientEmailDuplicateException;
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

    @PostMapping("/update")
    public ResponseEntity<ClientEntity> update(@RequestBody Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {
        return ResponseEntity.ok(clientService.save(client));
    }
    
}
