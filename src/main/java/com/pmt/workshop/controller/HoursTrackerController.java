package com.pmt.workshop.controller;


import com.pmt.workshop.dto.EffortDetailsDto;
import com.pmt.workshop.entity.EffortDetails;
import com.pmt.workshop.service.SaveHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HoursTrackerController {


//    @Autowired
//    EffortDetails effortDetails
    @Autowired
    SaveHoursService saveHoursService;

    @PostMapping("/logEffort")
    public ResponseEntity<?> logHours(@RequestBody EffortDetailsDto effortDetailsdto)
    {
       return saveHoursService.saveHoursAndUpdatePay(effortDetailsdto);
//       if(effortDetailsaved != null){
//           return ResponseEntity.ok(Map.of("Message","Efforts sucessfully logged"));
//       }
//       else{
//           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Message","Problem with saving of effort try again"));
//       }
    }
}
