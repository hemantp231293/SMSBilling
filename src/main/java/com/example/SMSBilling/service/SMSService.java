package com.example.SMSBilling.service;

import com.example.SMSBilling.entity.Plan;
import com.example.SMSBilling.entity.SMSServiceUsage;
import com.example.SMSBilling.repository.PlanRepository;
import com.example.SMSBilling.repository.PlanSubscriptionRepository;
import com.example.SMSBilling.repository.SMSServiceUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Service
public class SMSService {

    @Autowired
    SMSServiceUsageRepository smsServiceUsageRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PlanSubscriptionRepository planSubscriptionRepository;

    public ResponseEntity sendSMS(Long customerId, String message, List<String> receivingNumbers){
        Map<String, Object> response = new HashMap<>();
        try{
            Integer month = LocalDate.now().getMonth().getValue();
            //SMS Utility Service, which contains the actual logic to send the SMS will be called here

            smsServiceUsageRepository.updateUsageForCustomer(customerId, month, receivingNumbers.size());
            SMSServiceUsage usage = smsServiceUsageRepository.getUsageForCustomer(customerId, month);
            Long customerPlanId = planSubscriptionRepository.getSubscription(customerId);
            Plan customerPlan = planRepository.getPlan(customerPlanId);
            response.put("Customer ID", customerId);
            response.put("Message", message);
            response.put("Month", Month.of(month).name());
            if(usage.getSmsCount() <= customerPlan.getFreeMessageLimit())
                response.put("SMS Charge", 0);
            else
                response.put("SMS Charge", customerPlan.getSurchargePerSMS());
            return new ResponseEntity(response, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
