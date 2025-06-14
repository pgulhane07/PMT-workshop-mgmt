package com.pmt.workshop.service;

import com.pmt.workshop.entity.OrderDetails;
import com.pmt.workshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public OrderDetails saveOrder(OrderDetails orderDetails){

        System.out.println(orderDetails.toString());
        return orderRepository.save(orderDetails);
        //return orderDetails;
    }

    public OrderDetails getOrderDetailsbyId(Long orderId){
        return orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("ID not found"));
    }

}
