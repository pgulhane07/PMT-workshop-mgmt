package com.pmt.workshop.service;

import com.pmt.workshop.entity.JobRate;
import com.pmt.workshop.repository.AdminWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdminWorkService {

    @Autowired
    AdminWorkRepository adminWorkRepository;
    public ResponseEntity<?> saveJobRate(JobRate jobRate){

        JobRate updatedJob = adminWorkRepository.save(jobRate);
        return ResponseEntity.ok(Map.of("message","Job rate sucessfully added","Job Id",jobRate.getCode(),"Job rate Per side",jobRate.getRate()));
    }
}
