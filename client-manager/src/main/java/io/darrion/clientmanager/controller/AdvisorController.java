package io.darrion.clientmanager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Assignment;

@RestController("/advisor")
public class AdvisorController {

    @PostMapping(value = "/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> assign(@RequestBody Assignment assignment) {
        return ResponseEntity.ok(assignment);
    }
}
