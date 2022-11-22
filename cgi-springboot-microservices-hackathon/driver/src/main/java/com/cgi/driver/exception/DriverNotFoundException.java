package com.cgi.driver.exception;

public class DriverNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "DriverNotFoundException : Not found";
    }
}
