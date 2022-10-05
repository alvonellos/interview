package com.alvonellos.interview.exceptions;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice(annotations = RestController.class)
@RequestMapping(produces = "application/api.error+json")
@Log
public class InterviewControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InterviewIdNotFoundException.class)
    public ResponseEntity<InterviewAPIError> notFoundException(final InterviewIdNotFoundException e) {
        log.info("InterviewKeyNotFoundException: " + e.getMessage() + " " +  e.getId());
        return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<InterviewAPIError> argumentNotValid(final InterviewIllegalArgumentException e) {
        log.info("IllegalArgumentException handler executed");
        return error(e, HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InterviewAPIError> internalServerError(final Exception e) {
        log.severe("Internal server error: " + e.getMessage() + " " + e.getStackTrace());
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<InterviewAPIError> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new InterviewAPIError(logRef, message, exception), httpStatus);
    }

}