package com.cgi.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.insurance.model.Insurance;
import com.cgi.insurance.service.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService service;

    @PostMapping("/add")
    public Insurance addInsurance(@RequestBody() Insurance insurance) {
        return service.postInsurance(insurance);
    }

    @GetMapping("/all")
    public List<Insurance> getAllInsurance() {
        return service.getAllinsurances();
    }

    @GetMapping("/{id}")
    public Insurance getInsuranceById(@PathVariable Integer id) {
        return service.getInsuranceById(id);
    }

}
