package com.example.ddd_lab2.Services;


import com.example.ddd_lab2.Aggregates.Customer;
import com.example.ddd_lab2.Aggregates.Order;
import com.example.ddd_lab2.Repositories.CustomerRepo;
import com.example.ddd_lab2.Repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepository;
    private final OrderRepo orderRepo;

    public CustomerService(CustomerRepo customerRepository, OrderRepo orderRepo) {
        this.customerRepository = customerRepository;
        this.orderRepo = orderRepo;
    }


    boolean cancelOrder(Long customerId, Long orderId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Order> order = orderRepo.findById(orderId);
        order.get().setStatus("canceled");
        return true;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        return customerOptional.orElse(null);
    }


//    public void deleteCustomer(Long customerId) {
//        customerRepository.delete(customerId);
//    }

}