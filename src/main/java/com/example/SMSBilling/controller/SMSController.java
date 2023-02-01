package com.example.SMSBilling.controller;

import com.example.SMSBilling.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/sms")
public class SMSController {
    @Autowired
    SMSService smsService;

    @PostMapping
    public ResponseEntity sendSMS(@RequestParam(name = "cust_id") long customerId, @RequestParam(name="message") String message, @RequestParam(name="receiver") List<String> receivingNumbers){
        return smsService.sendSMS(customerId, message, receivingNumbers);
    }
}
