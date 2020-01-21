package com.aaroncb.javaorders.repos;

import com.aaroncb.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrdersRepository extends CrudRepository<Order, Long> {
    ArrayList<Order> findOrdersByAdvanceamountGreaterThan(double amount);
}
