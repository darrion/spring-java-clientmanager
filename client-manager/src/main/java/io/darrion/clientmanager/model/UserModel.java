package io.darrion.clientmanager.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserModel {
    Integer id;
    String firstName;
    String middleName;
    String lastName;
    Timestamp createdAt;
    Timestamp updatedAt;
}
