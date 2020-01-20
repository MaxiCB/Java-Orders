package com.aaroncb.javaorders.repos;

import com.aaroncb.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    ArrayList<Customer> findByCustnameContainingIgnoringCase(String custname);

}