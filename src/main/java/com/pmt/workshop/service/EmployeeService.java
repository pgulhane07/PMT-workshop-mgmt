package com.pmt.workshop.service;


import com.pmt.workshop.entity.EmployeeDetails;
import com.pmt.workshop.entity.ResponseMessage;
import com.pmt.workshop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeDetails employeeDetails;

//    private ResponseMessage sucessMessage;

    public ResponseMessage addEmployee(EmployeeDetails employeeDetailsNew){

        employeeDetails = employeeRepository.save(employeeDetailsNew);
        String s = "Employee Records sucessfully added to DB | Employee ID:" + employeeDetails.getEmployeeId();
//        sucessMessage.setMessage(s);
//        sucessMessage.setStatus(200);
        return  new ResponseMessage(200, s);

    }

    public EmployeeDetails getEmployee(Long id) {
        employeeDetails = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("No such User"));

        return employeeDetails;
    }

    public boolean updateEmployee(Long id, EmployeeDetails employeeDetailsUpdated) {
        employeeDetails =employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("No such User"));
        employeeDetails.setEmployeeName(employeeDetailsUpdated.getEmployeeName());
        employeeDetails.setAge(employeeDetailsUpdated.getAge());
        employeeDetails.setEmail(employeeDetailsUpdated.getEmail());
        employeeDetails.setAddress(employeeDetailsUpdated.getAddress());
        employeeDetails.setPhoneNumber(employeeDetailsUpdated.getPhoneNumber());

        employeeRepository.save(employeeDetails);
        return true;
    }

    public List<EmployeeDetails> getEmployeeAll() {
        return employeeRepository.findAll();
    }

    public boolean deleteRecord(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
