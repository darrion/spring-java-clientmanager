package io.darrion.clientmanager.handler;

import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.AdvisorEmailDuplicateException;
import io.darrion.clientmanager.response.ApiException;
import io.darrion.clientmanager.response.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdvisorControllerExceptionHandler {

    @ExceptionHandler(AdvisorDoesNotExistException.class)
    @ResponseBody
    public ResponseEntity<Object> advisorDoesNotExistException(AdvisorDoesNotExistException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add("Invalid advisor ID.");
        return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdvisorEmailDuplicateException.class)
    @ResponseBody
    public ResponseEntity<Object> advisorEmailDuplicate(AdvisorEmailDuplicateException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        errors.add("The given email address is registered to an existing advisor."); 
        return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }
}
