package com.example.SMSBilling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name="CUST_ID")
    private Long id;
    @Column(name="CUST_NAME")
    private String name;
    @Column(name="CONTACT_INFO")
    private String contactInfo;
    @Column(name="MAIL_ID")
    private String mailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}
