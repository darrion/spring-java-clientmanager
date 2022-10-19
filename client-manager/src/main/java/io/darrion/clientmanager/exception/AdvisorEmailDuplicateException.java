package io.darrion.clientmanager.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdvisorEmailDuplicateException extends Exception {
    String email;
}
