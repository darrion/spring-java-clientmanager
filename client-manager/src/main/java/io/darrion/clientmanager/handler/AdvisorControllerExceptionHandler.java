package io.darrion.clientmanager.handler;

import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.response.ErrorMessage;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.util.HashMap;

@ControllerAdvice
public class AdvisorControllerExceptionHandler {

    @ExceptionHandler(AdvisorDoesNotExistException.class)
    @ResponseBody
    public ErrorMessage advisorDoesNotExistException(AdvisorDoesNotExistException ex, WebRequest request) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("advisor_id", ex.getAdvisorId());
        ErrorMessage message = new ErrorMessage(ex.getClass().getSimpleName(), data);
        return message;
    }
}
