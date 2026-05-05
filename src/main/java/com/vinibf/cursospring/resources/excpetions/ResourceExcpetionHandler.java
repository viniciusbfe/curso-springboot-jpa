package com.vinibf.cursospring.resources.excpetions;

import com.vinibf.cursospring.services.exceptions.DatabaseExcpetion;
import com.vinibf.cursospring.services.exceptions.ResourceNotFoundExcpetion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExcpetionHandler {

    @ExceptionHandler(ResourceNotFoundExcpetion.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundExcpetion excpetion, HttpServletRequest request){
        String errorMessage = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), errorMessage, excpetion.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseExcpetion.class)
    public ResponseEntity<StandardError> database(DatabaseExcpetion excpetion, HttpServletRequest request){
        String errorMessage = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), errorMessage, excpetion.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
