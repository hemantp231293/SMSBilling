package com.example.SMSBilling.service;

import com.example.SMSBilling.entity.Customer;
import com.example.SMSBilling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomer(long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);

        if (customer != null)
            return customer;
        else
            throw new EntityNotFoundException();
    }

    public ResponseEntity addCustomer(Map<String, Object> customerPayload) {
        Customer customer = createCustomerFromPayload(customerPayload);
        try {
            Customer response = customerRepository.save(customer);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Customer createCustomerFromPayload(Map<String, Object> customerPayload) {
        Customer customer = new Customer();

        customer.setId((Long) customerPayload.get("id"));
        customer.setName(customerPayload.get("name").toString());
        customer.setMailId(customerPayload.get("mailid").toString());
        customer.setContactInfo(customerPayload.get("contactinfo").toString());

        return customer;
    }
}
