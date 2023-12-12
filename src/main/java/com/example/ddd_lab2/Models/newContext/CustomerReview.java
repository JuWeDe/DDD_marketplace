//package com.example.ddd_lab2.Models;
//
//
//
//import com.example.ddd_lab2.Aggregates.*;
//import jakarta.persistence.*;
//
//
//@Entity
//@Table(name = "reviews")
//public class CustomerReview {
//    @Column(name = "product_id", nullable = false)
//    private int productId;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Product product;
//
//    @Column(name = "client_id", nullable = false)
//    private int clientId;
//
//    @ManyToOne
//    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Customer customer;
//
//    @Column(name = "review", nullable = false)
//    private String review;
//    @Id
//    private Long id;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(int clientId) {
//        this.clientId = clientId;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
//}