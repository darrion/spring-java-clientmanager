package io.darrion.clientmanager.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import io.darrion.clientmanager.constants.Error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Advisor {
    Integer id;
    @NotNull(message = Error.EMAIL_REQUIRED) String email;
    @NotNull(message = Error.FIRST_NAME_REQUIRED) String firstName;
    @NotNull(message = Error.LAST_NAME_REQUIRED) String lastName;
    String middleName;
    Timestamp createdAt;
    Timestamp updatedAt;
}
