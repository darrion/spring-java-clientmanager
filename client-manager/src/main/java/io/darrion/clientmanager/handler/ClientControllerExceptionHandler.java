package io.darrion.clientmanager.handler;

import io.darrion.clientmanager.exception.ClientEmailDuplicateException;
import io.darrion.clientmanager.response.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ClientControllerExceptionHandler {

    @ExceptionHandler(ClientEmailDuplicateException.class)
    @ResponseBody
    public ResponseEntity<Object> usernameExistsException(ClientEmailDuplicateException ex, WebRequest request) {
        String error = "The given email address is registered to an existing user.";
        List<String> errors = new ArrayList<>();
        errors.add(error);
        return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }
}
