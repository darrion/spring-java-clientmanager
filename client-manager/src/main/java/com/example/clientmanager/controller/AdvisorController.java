package com.example.clientmanager.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.clientmanager.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.exception.AdvisorEmailDuplicateException;
import com.example.clientmanager.exception.ClientDoesNotExistException;
import com.example.clientmanager.model.Advisor;
import com.example.clientmanager.model.Assignment;
import com.example.clientmanager.response.ApiException;
import com.example.clientmanager.service.AdvisorService;
import com.example.clientmanager.service.ClientService;

@RestController
@RequestMapping("/advisor")
public class AdvisorController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AdvisorService advisorService;

    @Autowired 
    ClientService clientService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(
        @RequestBody Advisor advisor
    ) throws AdvisorEmailDuplicateException 
    {
        AdvisorEntity advisorEntity = advisorService.add(advisor);
        return ResponseEntity.ok(advisorEntity);
    }


    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(
        @RequestBody Advisor advisor
    ) throws AdvisorEmailDuplicateException 
    {
        if (advisor.getId() == null) {
            List<String> errors = new ArrayList<>();
            errors.add("id: ID required.");
            return new ResponseEntity<>(
                new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST
                );
        }
        AdvisorEntity advisorEntity = advisorService.update(advisor);
        return ResponseEntity.ok(advisorEntity);
    }

    @PostMapping(value = "/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> assign(
        @RequestBody Assignment assignment
    ) throws AdvisorDoesNotExistException, ClientDoesNotExistException
    {
        ClientEntity assignedClientEntity = advisorService.assign(assignment);
        return ResponseEntity.ok(assignedClientEntity);
    }

    @GetMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClients(
        @RequestBody Advisor advisor
    ) throws AdvisorDoesNotExistException {
        List<ClientEntity> clients = advisorService.getClients(advisor);
        return ResponseEntity.ok(clients);
    }

}
