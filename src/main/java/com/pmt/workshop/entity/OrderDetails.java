package com.pmt.workshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @NonNull
    private LocalDateTime orderDate;

    @NonNull
    private String type;

    @NonNull
    private int quantity;

    @NonNull
    private String specification;

    private double weight;

    @NonNull
    private String organisation;

    private String placedBy;

    @NonNull
    private LocalDateTime expectedDeadline;

    private LocalDateTime workStartDate;

    private LocalDateTime workEndDate;

    private String Machine;

    private double totalScrap;

    @OneToMany(mappedBy = "orderDetails",cascade = CascadeType.ALL)
    private List<EffortDetails> effortDetails;
}
