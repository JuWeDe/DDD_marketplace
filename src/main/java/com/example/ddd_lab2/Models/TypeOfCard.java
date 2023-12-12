//package com.example.ddd_lab2.Models;
//
//
//import com.example.ddd_lab2.Aggregates.Customer;
//import jakarta.persistence.*;
//
//import java.util.Collection;
//
//
//@Entity
//@Table(name = "type_of_card")
//public class TypeOfCard {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @OneToMany(mappedBy = "typeOfCard")
//    private Collection<Customer> customers;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Collection<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Collection<Customer> customers) {
//        this.customers = customers;
//    }
//}