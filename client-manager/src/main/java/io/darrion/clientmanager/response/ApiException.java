package io.darrion.clientmanager.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiException {
    private HttpStatus httpStatus;
    private List<String> errors;
}