package io.darrion.clientmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdvisorDoesNotExistException extends Exception {
    Integer advisorId;
}
