package com.pmt.workshop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class EffortDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long logId;

    private String jobType;

    private int jobCount;

    private String jobSpecification;

    private String workMonth;
    private String workYear;

    @ManyToOne
    @JoinColumn(name = "employeeId",nullable = false)
    private EmployeeDetails employeeDetails;

    @ManyToOne
    @JoinColumn(name="orderId",nullable = false)
    private OrderDetails orderDetails;

}
