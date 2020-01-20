package com.aaroncb.javaorders.repos;

import com.aaroncb.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long> {
}
