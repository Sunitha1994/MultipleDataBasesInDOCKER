package com.mysqlpostgres.controller;

import com.mysqlpostgres.domain.Customer;
import com.mysqlpostgres.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private @Autowired
    CustomerService customerService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);


    @PostMapping("/customer")
    public @ResponseBody Customer save(@RequestBody Customer customer){
        LOGGER.info("*****Customer Type*******"+customer.getType());
        return customerService.saveDetails(customer);
    }

    @GetMapping("/customers")
    public @ResponseBody
    Customer getDetails(String gstNumber) {
        LOGGER.info("*****Customer Id*******",gstNumber);
        return customerService.getDetails(gstNumber);
    }
}
