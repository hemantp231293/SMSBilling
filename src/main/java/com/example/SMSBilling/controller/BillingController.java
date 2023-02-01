package com.example.SMSBilling.controller;

import com.example.SMSBilling.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/bill")
public class BillingController {

    @Autowired
    BillingService billingService;

    @GetMapping
    public ResponseEntity getCustomerBill(@RequestParam(name = "cust_id") long customerId, @RequestParam(name = "month", required = false) Integer month) {
        return billingService.getCustomerBill(customerId, month);
    }

}
