package com.pmt.workshop.repository;

import com.pmt.workshop.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetails,Long> {
}
