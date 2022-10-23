package io.darrion.clientmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.AssignmentEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.AdvisorEmailDuplicateException;
import io.darrion.clientmanager.exception.ClientDoesNotExistException;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Assignment;
import io.darrion.clientmanager.response.ApiException;
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
        AssignmentEntity assignmentEntity = advisorService.assign(assignment); 
        return ResponseEntity.ok(assignmentEntity);
    }

}
