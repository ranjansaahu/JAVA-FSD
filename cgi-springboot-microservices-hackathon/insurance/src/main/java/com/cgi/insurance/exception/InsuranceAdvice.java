package com.cgi.insurance.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mongodb.MongoWriteException;

@RestControllerAdvice
public class InsuranceAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> notFoundException(NoSuchElementException ex) {

        Map<String, String> errMap = new HashMap<>();
        errMap.put("errorMessage", "Not found");
        return errMap;

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MongoWriteException.class)
    public Map<String, String> insuranceExistException(MongoWriteException ex) {

        Map<String, String> errMap = new HashMap<>();
        errMap.put("errorMessage", "Already exist ");
        return errMap;

    }
}
