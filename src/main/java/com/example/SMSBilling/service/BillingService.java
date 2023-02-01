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
import java.util.HashMap;
import java.util.Map;

@Service
public class BillingService {

    @Autowired
    SMSServiceUsageRepository smsServiceUsageRepository;

    @Autowired
    PlanSubscriptionRepository planSubscriptionRepository;

    @Autowired
    PlanRepository planRepository;

    public ResponseEntity getCustomerBill(long customerId, Integer month){
        try{
            if(month == null)
                month = LocalDate.now().getMonth().getValue();
            SMSServiceUsage usage = smsServiceUsageRepository.getUsageForCustomer(customerId, month);
            Long customerPlanId = planSubscriptionRepository.getSubscription(customerId);
            Plan customerPlan = planRepository.getPlan(customerPlanId);
            Map<String, Object> response = new HashMap<>();
            response.put("Customer ID", customerId);
            response.put("Month", Month.of(month).name());
            if(usage.getSmsCount() < customerPlan.getFreeMessageLimit())
                response.put("Billing Amount", 0);
            else
                response.put("Billing Amount",(usage.getSmsCount() - customerPlan.getFreeMessageLimit())*customerPlan.getSurchargePerSMS());
            return new ResponseEntity(response,HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
