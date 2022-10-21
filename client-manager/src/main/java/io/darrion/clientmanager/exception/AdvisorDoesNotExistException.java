package io.darrion.clientmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDoesNotExistException extends Exception {
    Integer advisorId;
}
