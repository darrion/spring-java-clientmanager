package io.darrion.clientmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.entity.SpecializationEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Specialization;
import io.darrion.clientmanager.service.SpecializationService;

@RestController
@RequestMapping("/advisor/specialization")
public class SpecializationController {

    @Autowired
    SpecializationService specializationService;
    
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(
        @RequestBody Specialization specialization
    ) 
    {
        SpecializationEntity specializationEntity = specializationService.add(specialization);
        return ResponseEntity.ok(specializationEntity);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(
        @RequestBody Specialization specialization
    ) 
    {
        SpecializationEntity specializationEntity = specializationService.update(specialization);
        return ResponseEntity.ok(specializationEntity);
    }
}
