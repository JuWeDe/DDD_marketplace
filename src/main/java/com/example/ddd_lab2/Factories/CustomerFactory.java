package com.example.ddd_lab2.Factories;


import com.example.ddd_lab2.Aggregates.Customer;
import com.example.ddd_lab2.Repositories.CustomerRepo;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class CustomerFactory {
    private final CustomerRepo customerRepo;

    public CustomerFactory(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(String paymentType, String cardType, String name) {
        Customer customer = new Customer();
        customer.setPaymentType(paymentType);
        customer.setCardType(cardType);
        customer.setName(name);
        return customerRepo.save(customer);
    }


}