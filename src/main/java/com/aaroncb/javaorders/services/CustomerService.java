package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService
{

    List<Customer> findAllCustomers();

    Customer findCustomerByID(long id);

    List<Customer> findByCustNameLike(String custname);
}
