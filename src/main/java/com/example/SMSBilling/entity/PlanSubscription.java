package com.example.SMSBilling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PLANSUBSCRIPTION")
public class PlanSubscription {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="CUST_ID")
    private Long customerId;

    @Column(name="PLAN_ID")
    private Long planId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
