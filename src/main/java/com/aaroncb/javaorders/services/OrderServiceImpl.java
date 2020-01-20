package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.models.Order;
import com.aaroncb.javaorders.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Order> findAllOrders()
    {
        List<Order> list = new ArrayList<>();
        ordersRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Order findOrderById(long id) throws EntityNotFoundException {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + Long.toString(id) + " Not Found"));
    }
}
