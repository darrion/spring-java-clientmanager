package com.example.clientmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Assignment {

    @JsonProperty("advisor_id")
    Integer advisorId; 

    @JsonProperty("client_id")
    Integer clientId;
}
