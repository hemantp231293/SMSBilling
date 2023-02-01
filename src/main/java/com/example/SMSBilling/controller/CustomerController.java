package com.example.SMSBilling.controller;

import com.example.SMSBilling.entity.Customer;
import com.example.SMSBilling.service.BillingService;
import com.example.SMSBilling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    @ResponseBody
    Customer getCustomer(@RequestParam(name = "cust_id") long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    ResponseEntity addCustomer(@RequestBody Map<String, Object> customerPayload) {
        return customerService.addCustomer(customerPayload);
    }
}
