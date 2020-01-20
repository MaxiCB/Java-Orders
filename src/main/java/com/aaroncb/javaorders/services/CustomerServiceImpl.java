package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers()
    {
        List<Customer> list = new ArrayList<>();
        customerRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerByID(long id) throws EntityNotFoundException
    {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + Long.toString(id) + " Not Found"));
    }

    @Override
    public List<Customer> findByCustNameLike(String custname)
    {
        ArrayList<Customer> list = customerRepository.findByCustnameContainingIgnoringCase(custname);
        return list;
    }

}
