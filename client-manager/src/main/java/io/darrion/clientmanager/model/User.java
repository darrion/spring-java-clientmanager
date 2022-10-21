package io.darrion.clientmanager.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class User {
    Integer id;
    @NotNull(message = "Email required.") String email;
    @NotNull(message = "First name required.") String firstName;
    @NotNull(message = "Last name required.") String lastName;
    String middleName;
    Timestamp createdAt;
    Timestamp updatedAt;
}
