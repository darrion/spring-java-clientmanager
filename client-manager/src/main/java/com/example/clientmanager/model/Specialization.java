package com.example.clientmanager.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Specialization {
    Integer id; 
    @NotNull
    String focus;
    @NotNull
    Integer advisorId;
}
