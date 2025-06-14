package com.pmt.workshop.controller;

import com.pmt.workshop.entity.EmployeeDetails;
import com.pmt.workshop.entity.ResponseMessage;
import com.pmt.workshop.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

//    @Autowired
//    EmployeeDetails employeeDetails;
    @Autowired
    private  EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/getEmployeeById/{id}")
    public EmployeeDetails getEmployeeById(@PathVariable("id") Long id){
        logger.info("Get request received for employee ID "+id );

        return employeeService.getEmployee(id);
    }
    @GetMapping("/getEmployeeAll")
    public List<EmployeeDetails> getEmployeeAll(){
        logger.info("Get request received for employee ID " );

        return employeeService.getEmployeeAll();
    }
    @PostMapping("/addEmployee")
    public ResponseMessage addEmployee(@RequestBody EmployeeDetails employeeDetails){

        logger.info("Post request received to add Employee Details"+employeeDetails.toString());
        if(employeeDetails.getAge() > 18 && employeeDetails.getPhoneNumber().length()==10 && employeeDetails.getEmail().endsWith("@gmail.com")){
            return employeeService.addEmployee(employeeDetails);
        }
        else{
            return new ResponseMessage(400,"Invalid Employee Details");
        }


    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseMessage updateEmployeeDetails(@PathVariable("id") Long id, @RequestBody EmployeeDetails employeeDetails){
        if(employeeService.updateEmployee(id, employeeDetails)){
            return new ResponseMessage(200,"Sucessfully updated the data");
        }
        else{
            return new ResponseMessage(400,"Data update attempt unsucessful");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteEmployeeById(@PathVariable("id") Long id){
        if(employeeService.deleteRecord(id)){
            return new ResponseMessage(200,"Sucessfully Deleted the data");
        }
        else{
            return new ResponseMessage(400,"Data Deletion attempt unsucessful");
        }
    }


}
