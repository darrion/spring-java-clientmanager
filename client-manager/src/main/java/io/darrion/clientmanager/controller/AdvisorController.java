package io.darrion.clientmanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.model.Advisor;

@RestController("/advisor")
public class AdvisorController {

    @PostMapping("/assign")
    public AdvisorEntity assign(Integer clientId, Advisor advisor) {
        return null;
    }
}
