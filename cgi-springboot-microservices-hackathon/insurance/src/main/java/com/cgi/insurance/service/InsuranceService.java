package com.cgi.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.insurance.repository.InsuranceRepository;
import com.cgi.insurance.model.Insurance;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository repo;

    public Insurance postInsurance(Insurance insurance) {
        repo.save(insurance);
        return insurance;
    }

    public List<Insurance> getAllinsurances() {
        return repo.findAll();
    }

    public Insurance getInsuranceById(Integer id) {
        return repo.findById(id).get();
    }
}
