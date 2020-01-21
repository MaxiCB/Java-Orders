package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    Order findOrderById(long id);

    List<Order> findAdvanceOrders(double amount);

}
