package com.pmt.workshop.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class EffortDetailsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long logId;

    private String jobType;

    private int jobCount;

    private String jobSpecification;
    private String workMonth;
    private String workYear;
    private Long employeeId;
    private Long orderId;
}
