package com.aaroncb.javaorders.controllers;

import com.aaroncb.javaorders.models.Order;
import com.aaroncb.javaorders.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders",
            produces = {"application/json"})
    public ResponseEntity<?> listAll()
    {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders,
                HttpStatus.OK);
    }

    @GetMapping(value = "/order/{id}",
                produces = {"application/json"})
    public ResponseEntity<?> getOrderById(
            @PathVariable
                    Long id)
    {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/advanceamount",
                produces = {"application/json"})
    public ResponseEntity<?> getByAdvance(){
        List <Order> orders = orderService.findAdvanceOrders(0.0);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
