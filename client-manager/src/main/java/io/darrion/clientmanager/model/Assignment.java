package io.darrion.clientmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Assignment {

    @JsonProperty("advisor_id")
    Integer advisorId; 

    @JsonProperty("client_id")
    Integer clientId;
}
