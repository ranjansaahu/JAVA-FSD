package com.cgi.driver.service;

import com.cgi.driver.exception.DriverNotFoundException;
import com.cgi.driver.exception.DuplicateDriverIdException;
import com.cgi.driver.model.Driver;
import com.cgi.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver addDriver(Driver driver) {
        Optional<Driver> optional = driverRepository.findById(driver.getDriverid());
        if (optional.isPresent()) {
            throw new DuplicateDriverIdException();
        }
        return (driverRepository.save(driver));
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();

    }

    public Driver getDriver(Integer driverid) {
        Optional<Driver> optional = driverRepository.findById(driverid);
        if (optional.isEmpty()) {
            throw new DriverNotFoundException();
        }
        return optional.get();
    }

    public Driver delete(Integer driverid) {
        Optional<Driver> optional = driverRepository.findById(driverid);
        if (optional.isEmpty()) {
            throw new DriverNotFoundException();
        }
        driverRepository.deleteById(driverid);
        return optional.get();
    }
}
