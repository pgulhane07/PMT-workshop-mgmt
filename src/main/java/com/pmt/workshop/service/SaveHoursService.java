package com.pmt.workshop.service;

import com.pmt.workshop.dto.EffortDetailsDto;
import com.pmt.workshop.entity.*;
import com.pmt.workshop.repository.LogHoursRepository;
import com.pmt.workshop.repository.PayRateRepository;
import com.pmt.workshop.repository.PaymentDueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SaveHoursService {

    @Autowired
    LogHoursRepository logHoursRepository;
    @Autowired
    PayRateRepository payRateRepository;
    @Autowired
    PaymentDueRepository paymentDueRepository;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    OrderService orderService;


    public ResponseEntity<?> saveHoursAndUpdatePay(EffortDetailsDto effortDetailsdto){

        String jobType=effortDetailsdto.getJobType();
        String specification = effortDetailsdto.getJobSpecification();

        EmployeeDetails employeeDetails = employeeService.getEmployee(effortDetailsdto.getEmployeeId());
        OrderDetails orderDetails= orderService.getOrderDetailsbyId(effortDetailsdto.getOrderId());
        EffortDetails effortDetail = new EffortDetails();

        effortDetail.setJobCount(effortDetailsdto.getJobCount());
        effortDetail.setJobSpecification(effortDetailsdto.getJobSpecification());
        effortDetail.setJobType(effortDetailsdto.getJobType());
        effortDetail.setWorkMonth(effortDetailsdto.getWorkMonth());
        effortDetail.setWorkYear(effortDetailsdto.getWorkYear());

        effortDetail.setEmployeeDetails(employeeDetails);
        effortDetail.setOrderDetails(orderDetails);


        String code=jobType+"-"+specification;

        return calculateAndUpdateLogPay(code, effortDetail);

//            return logHoursRepository.save(effortDetail);
//        }


    }

    private ResponseEntity<?> calculateAndUpdateLogPay(String code, EffortDetails effortDetails) {

        JobRate jobRate = payRateRepository.findById(code).orElseThrow(()-> new RuntimeException("No such job"));

        double cost=jobRate.getRate();
        double paymentUpd = cost * effortDetails.getJobCount();

       // long payroleId = paymentDueRepository.find;
        int c=paymentDueRepository.updatePaycheckAmount(effortDetails.getEmployeeDetails().getEmployeeId(),effortDetails.getWorkMonth(),effortDetails.getWorkYear(),paymentUpd);
        if(c==0){
            PaymentDue newMonth = new PaymentDue();
            newMonth.setAmount(paymentUpd);
            newMonth.setEmployeeDetails(effortDetails.getEmployeeDetails());
            newMonth.setYear(effortDetails.getWorkYear());
            newMonth.setMonth(effortDetails.getWorkMonth());
            newMonth.setStatus("Current Pay Cycle");
            paymentDueRepository.save(newMonth);
        }
        EffortDetails savedEffort = logHoursRepository.save(effortDetails);
        return ResponseEntity.ok(Map.of("message","Work Hours Sucessfully added","Payroll detail",effortDetails.getWorkMonth(),"Log Id",savedEffort.getLogId()));

        //   }
   // return ResponseEntity.ok(Map.of());
    }

}
