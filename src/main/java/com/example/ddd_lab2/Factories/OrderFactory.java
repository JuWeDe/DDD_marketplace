package com.example.ddd_lab2.Factories;

import com.example.ddd_lab2.Aggregates.Order;
import com.example.ddd_lab2.Aggregates.Product;
import com.example.ddd_lab2.Models.Address;
import com.example.ddd_lab2.Repositories.OrderRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactory {
    OrderRepo orderRepo;

    public OrderFactory(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order creatOrder(String status, Address address, List<Product> products) {
        Order order = new Order();
        order.setStatus(status);
        if (address != null) {
            order.setDeliveryAddress(address);
        } else {
            System.out.println("No address provided");
        }
        if (!products.isEmpty()) {
            order.setProductList(products);
        } else {
            System.out.println("Cant create empty order");
        }
        return orderRepo.save(order);
    }


}
