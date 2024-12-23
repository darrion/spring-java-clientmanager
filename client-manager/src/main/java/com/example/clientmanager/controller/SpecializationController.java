package com.example.clientmanager.controller;

import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientmanager.entity.SpecializationEntity;
import com.example.clientmanager.model.Specialization;
import com.example.clientmanager.service.SpecializationService;

@RestController
@RequestMapping("/advisor/specialization")
public class SpecializationController {

    @Autowired
    SpecializationService specializationService;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(
        @RequestBody Specialization specialization
    ) throws AdvisorDoesNotExistException {
        SpecializationEntity specializationEntity = specializationService.add(specialization);
        return ResponseEntity.ok(specializationEntity);
    }
}
