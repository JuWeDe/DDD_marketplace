package com.example.ddd_lab2.Repositories;


import com.example.ddd_lab2.Aggregates.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
