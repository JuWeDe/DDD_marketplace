package com.example.ddd_lab2.Aggregates;


import com.example.ddd_lab2.Models.Address;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String status;
    @OneToMany
    private List<Product> productList;
    @OneToOne
    private Address deliveryAddress;


    public Order() {
    }

    public Order(String status, List<Product> productList, Address deliveryAddress) {
        this.status = status;
        this.productList = productList;
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
