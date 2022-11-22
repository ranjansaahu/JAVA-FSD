package com.cgi.driver.exception;

public class DuplicateDriverIdException extends RuntimeException {
    @Override
    public String toString() {
        return "DuplicateDriverIdException : This driver already exist";
    }
}
