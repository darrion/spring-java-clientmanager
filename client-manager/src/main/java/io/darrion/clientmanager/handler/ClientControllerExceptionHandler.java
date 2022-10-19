package io.darrion.clientmanager.handler;

import io.darrion.clientmanager.exception.ClientEmailDuplicateException;
import io.darrion.clientmanager.response.ErrorMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

@ControllerAdvice
public class ClientControllerExceptionHandler {

    @ExceptionHandler(ClientEmailDuplicateException.class)
    @ResponseBody
    public ErrorMessage usernameExistsException(ClientEmailDuplicateException ex, WebRequest request) {
        String clientEmail = ex.getEmail();
        HashMap<String, Object> data = new HashMap<>();
        data.put("email", clientEmail);
        ErrorMessage message = new ErrorMessage(ex.getClass().getSimpleName(), data);
        return message;
    }
}
