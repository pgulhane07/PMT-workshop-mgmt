package com.pmt.workshop.controller;


import com.pmt.workshop.entity.JobRate;
import com.pmt.workshop.service.AdminWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobRateController {

    @Autowired
    AdminWorkService adminWorkService;
    @PostMapping("/addJobRate")
    public ResponseEntity<?> addJobRate(@RequestBody JobRate jobRate)
    {
      return   adminWorkService.saveJobRate(jobRate);
    }
}
