package com.example.SMSBilling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "SMSSERVICEUSAGE")
public class SMSServiceUsage {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="CUST_ID")
    private Long customerId;
    @Column(name="USAGE_MONTH")
    private Integer usageMonth;
    @Column(name="SMS_COUNT")
    private Long smsCount;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getUsageMonth() {
        return usageMonth;
    }

    public void setUsageMonth(Integer usageMonth) {
        this.usageMonth = usageMonth;
    }

    public Long getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Long smsCount) {
        this.smsCount = smsCount;
    }
}
