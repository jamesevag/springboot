package de.springboot.rest.services.restfulwebservices;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserExceptions(Exception e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError error = ex.getBindingResult().getFieldError();
        ExceptionResponse response = new ExceptionResponse(new Date(), "Validation error", error.getDefaultMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}
