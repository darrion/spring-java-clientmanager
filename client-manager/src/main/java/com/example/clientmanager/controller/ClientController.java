package com.example.clientmanager.controller;

import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.exception.ClientEmailDuplicateException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientmanager.model.Client;
import com.example.clientmanager.response.ApiException;
import com.example.clientmanager.service.ClientService;

@Validated
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {
        return ResponseEntity.ok(clientService.add(client));
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@Valid @RequestBody Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {
        if (client.getId() == null) {
            List<String> errors = new ArrayList<>();
            errors.add("id: ID required.");
            return new ResponseEntity<>(
                new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST
                );
        }
        return ResponseEntity.ok(clientService.update(client));
    }
    
}
