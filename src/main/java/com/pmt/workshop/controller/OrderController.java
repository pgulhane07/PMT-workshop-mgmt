package com.pmt.workshop.controller;

import com.pmt.workshop.entity.OrderDetails;
import com.pmt.workshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDetails orderDetails){

        orderDetails.setOrderDate(LocalDateTime.now());

        OrderDetails orderDetailsSaved = orderService.saveOrder(orderDetails);

        if(orderDetailsSaved != null) {
            return ResponseEntity.ok(Map.of("Mesasge", "Order Sucessfully place", "Order Id", orderDetailsSaved.getOrderId()));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("Message","Order could not be place"));
        }

    }
}
