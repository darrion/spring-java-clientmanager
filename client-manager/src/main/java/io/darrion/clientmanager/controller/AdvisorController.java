package io.darrion.clientmanager.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.service.AdvisorService;
import io.darrion.clientmanager.service.ClientService;

@RestController
@RequestMapping("/advisor")
public class AdvisorController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AdvisorService advisorService;

    @Autowired 
    ClientService clientService; 

    @PostMapping(value = "/assignClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> assign(
        @RequestBody Client client
    ) 
    {
        try {
            ClientEntity clientEntity = clientService.add(client);
            return ResponseEntity.ok(clientEntity);
        } catch (Exception ex) {
            return ResponseEntity.ok(ex);
        }
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(
        @RequestBody Advisor advisor
    ) 
    {
        AdvisorEntity advisorEntity = advisorService.add(advisor);
        return ResponseEntity.ok(advisorEntity);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(
        @RequestBody Advisor advisor
    ) 
    {
        AdvisorEntity advisorEntity = advisorService.add(advisor);
        return ResponseEntity.ok(advisorEntity);
    }

}
