package com.luandeoliveira.hr_user.controllers.exceptions;

import com.luandeoliveira.hr_user.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public StandardError userNotFound(HttpServletRequest request, UserNotFoundException e){
        return new StandardError(Instant.now(), "Resource not found", e.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI());
    }
}
