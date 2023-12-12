package com.example.ddd_lab2.Services;

import com.example.ddd_lab2.Aggregates.Order;
import com.example.ddd_lab2.Aggregates.Product;
import com.example.ddd_lab2.Repositories.CustomerRepo;
import com.example.ddd_lab2.Repositories.OrderRepo;
import com.example.ddd_lab2.Repositories.ProductRepo;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    public OrderService(OrderRepo orderRepository, CustomerRepo customerRepo) {
        this.orderRepository = orderRepository;
        this.customerRepo = customerRepo;
    }

    private OrderRepo orderRepository;

    private CustomerRepo customerRepo;
    private ProductRepo productRepo;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        return orderOptional.orElse(null);
    }

    // подсчет суммы заказа
    public double calculateOrderTotal(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            Hibernate.initialize(order.getProductList()); // Инициализация productList
            return order.getProductList().stream()
                    .mapToDouble(product -> product.getPrice() * product.getAvailableQuantity())
                    .sum();
        }
        return 0.0;
    }


    //   применение скидки
    public double applyDiscount(Long orderId, double discountPercentage) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            double orderTotal = calculateOrderTotal(orderId);
            double discountAmount = orderTotal * discountPercentage;
            double discountedPrice = orderTotal - discountAmount;
            return discountedPrice;
        }
        return 0.0;
    }
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void updateOrderStatus(Long orderId, String newStatus) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(newStatus);
            orderRepository.save(order);
        }
    }


    public void cancelOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus("canceled");
            orderRepository.save(order);
        }
    }
}