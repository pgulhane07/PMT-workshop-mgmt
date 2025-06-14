package com.pmt.workshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class PaymentDue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payCheckId;

    @ManyToOne
    @JoinColumn(name = "employeeId",nullable = false)
    private EmployeeDetails employeeDetails;

    private String month;
    private String year;
    private Double amount;
    private String status;
}
