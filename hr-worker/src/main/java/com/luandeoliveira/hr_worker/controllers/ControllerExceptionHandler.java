package com.luandeoliveira.hr_worker.controllers;

import com.luandeoliveira.hr_worker.controllers.exceptions.StandardError;
import com.luandeoliveira.hr_worker.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public StandardError resourceNotFoundException(HttpServletRequest request, ResourceNotFoundException exception){
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setError("Resource not found");
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        return standardError;
    }
}
