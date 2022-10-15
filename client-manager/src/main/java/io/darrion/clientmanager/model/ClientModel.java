package io.darrion.clientmanager.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientModel {
    Integer id;
    String firstName;
    String middleName;
    String lastName;
    Timestamp createdAt;
    Timestamp updatedAt;
}
