package com.cgi.insurance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.insurance.model.Insurance;

@Repository
public interface InsuranceRepository extends MongoRepository<Insurance, Integer> {

}
