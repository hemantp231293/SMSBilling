package com.example.SMSBilling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PLAN")
public class Plan {
    @Id
    @Column(name="PLAN_ID")
    private Long id;

    @Column(name="PLAN_NAME")
    private String planName;

    @Column(name="MESSAGE_LIMIT")
    private Integer freeMessageLimit;

    @Column(name="SURCHARGE")
    private Float surchargePerSMS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getFreeMessageLimit() {
        return freeMessageLimit;
    }

    public void setFreeMessageLimit(Integer freeMessageLimit) {
        this.freeMessageLimit = freeMessageLimit;
    }

    public Float getSurchargePerSMS() {
        return surchargePerSMS;
    }

    public void setSurchargePerSMS(Float surchargePerSMS) {
        this.surchargePerSMS = surchargePerSMS;
    }
}
