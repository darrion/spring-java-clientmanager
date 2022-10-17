package io.darrion.clientmanager.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Specialization {
    Integer id; 
    String focus;
    Advisor advisor;
}
