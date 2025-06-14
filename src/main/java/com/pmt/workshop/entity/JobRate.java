package com.pmt.workshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class JobRate {
    @Id
    private String code;
    private double rate;
}
