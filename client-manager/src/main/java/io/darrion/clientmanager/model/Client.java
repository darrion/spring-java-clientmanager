package io.darrion.clientmanager.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends User {
    Integer advisorId;
}
