package io.darrion.clientmanager.model;

import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import io.darrion.clientmanager.constants.Error;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Validated
public class Client {
    
    Integer id;
    @NotNull(message = Error.EMAIL_REQUIRED) String email;
    @NotNull(message = Error.FIRST_NAME_REQUIRED) String firstName;
    @NotNull(message = Error.LAST_NAME_REQUIRED) String lastName;
    String middleName;
    Timestamp createdAt;
    Timestamp updatedAt;
    Integer advisorId;
}
