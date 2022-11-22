package com.cgi.driver.controller;

import com.cgi.driver.model.Driver;
import com.cgi.driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<Driver> addDriver(@RequestBody() Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.addDriver(driver));
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        if (drivers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(drivers);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(drivers);
        }
    }

    @GetMapping("/{driverid}")
    public ResponseEntity<Driver> getProduct(@PathVariable() Integer driverid) {
        Driver driver;
        driver = driverService.getDriver(driverid);
        return ResponseEntity.status(HttpStatus.FOUND).body(driver);
    }

    @DeleteMapping("/{driverid}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable() Integer driverid) {
        Driver driver = null;
        return ResponseEntity.status(HttpStatus.OK).body(driverService.delete(driverid));
    }
}
