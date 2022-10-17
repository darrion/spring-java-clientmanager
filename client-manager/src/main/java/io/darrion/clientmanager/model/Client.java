package io.darrion.clientmanager.model;

import io.darrion.clientmanager.entity.AdvisorEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends User {
    Advisor advisor;
}
