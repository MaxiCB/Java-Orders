package com.aaroncb.javaorders.controllers;

import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/orders",
            produces = {"application/json"})
    public ResponseEntity<?> listAll()
    {
        List<Customer> myCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(myCustomers,
                HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{custcode}",
            produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(
            @PathVariable
                    Long custcode)
    {
        Customer cust = customerService.findCustomerByID(custcode);
        return new ResponseEntity<>(cust,
                HttpStatus.OK);
    }

    @GetMapping(value = "/customer/likename/{custname}",
            produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(
            @PathVariable
                    String custname)
    {
        List<Customer> cust = customerService.findByCustNameLike(custname);
        return new ResponseEntity<>(cust,
                HttpStatus.OK);
    }
}
