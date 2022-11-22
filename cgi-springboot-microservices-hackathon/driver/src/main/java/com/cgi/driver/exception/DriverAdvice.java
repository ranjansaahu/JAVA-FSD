package com.cgi.driver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class DriverAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateDriverIdException.class)
    public ResponseEntity<String> handleDuplicateDriverIdException(DuplicateDriverIdException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("" + e);
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<String> handleDriverNotFoundException(DriverNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("From Advice" + e);
    }

}
