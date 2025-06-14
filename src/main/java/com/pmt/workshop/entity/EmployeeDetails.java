package com.pmt.workshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Entity
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String employeeName;

    @OneToMany(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
    private List<EffortDetails> effortDetails;

    @OneToMany(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
    private List<PaymentDue> paymentDues;

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private int age;
    private String phoneNumber;
    private String email;
    private String address;


}
