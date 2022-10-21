package io.darrion.clientmanager.controller;

import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.ClientEmailDuplicateException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.response.ApiException;
import io.darrion.clientmanager.service.ClientService;

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
