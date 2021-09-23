package com.bosonit.restservice.content.persona.infrastructure.exception;

import com.bosonit.restservice.content.persona.infrastructure.exception.response.CustomError;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> notFound(
            NotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new CustomError(404, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity<CustomError> httpClientErrorException(
            HttpClientErrorException e, WebRequest request) {
        return new ResponseEntity<>(new CustomError(e.getRawStatusCode(), e.getMessage().substring(4)),
                e.getStatusCode());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<CustomError> constraintViolationException(
            ConstraintViolationException e, WebRequest request) {
        List<ConstraintViolation> c = e.getConstraintViolations().stream().collect(Collectors.toList());
        return new ResponseEntity<>(new CustomError(422, c.get(0).getMessage()),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
