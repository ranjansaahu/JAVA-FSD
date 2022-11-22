package com.cgi.insurance.exception;


public class insuranceExistException extends RuntimeException {
    @Override
    public String toString() {
        return "\"errorMessage\", \"Already exist\"";
    }

}
