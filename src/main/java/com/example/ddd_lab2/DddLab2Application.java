package com.example.ddd_lab2;

import com.example.ddd_lab2.Aggregates.Customer;
import com.example.ddd_lab2.Aggregates.Order;
import com.example.ddd_lab2.Aggregates.Product;
import com.example.ddd_lab2.Aggregates.Promotion;
import com.example.ddd_lab2.Factories.CustomerFactory;
import com.example.ddd_lab2.Factories.OrderFactory;
import com.example.ddd_lab2.Factories.ProductFactory;
import com.example.ddd_lab2.Factories.PromotionFactory;
import com.example.ddd_lab2.Models.Address;
import com.example.ddd_lab2.Repositories.AddressRepo;
import com.example.ddd_lab2.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DddLab2Application implements CommandLineRunner {
    @Autowired
    private PromotionFactory promotionFactory;

    @Autowired
    private ProductFactory productFactory;

    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private CustomerFactory customerFactory;
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(DddLab2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Создание сущностей
        Promotion promotion = promotionFactory.createPromotion("Скидка на товары", "2021-05-20", "2021-05-31", 1L);
        Product product1 = productFactory.createProduct("Телефон", 33999.99, 1000);
        Product product2 = productFactory.createProduct("Ноутбук", 77999.99, 500);
        Address address = createAddress("Москва", "ул. Примерная", "123456");
        Customer customer = customerFactory.createCustomer("Кредитная карта", "Visa", "Иванов Иван");


        // Создание заказа из продуктов
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Order order = orderFactory.creatOrder("created", address, products);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orderService.getAllOrders(); // Пример получения всех заказов, чтобы убедиться, что заказ добавлен
        customer.setOrders(orders);

//        double orderTotal = orderService.calculateOrderTotal(order.getOrderId());
//        System.out.println("Стоимость заказа: " + orderTotal);
//
//        // Применение скидки к заказу
//        double discountedPrice = orderService.applyDiscount(order.getOrderId(), 0.1);
//        System.out.println("Цена с примененной скидкой: " + discountedPrice);

//        // Изменение статуса заказа
//        orderService.updateOrderStatus(order.getOrderId(), "Shipped");
        // отмена
        orderService.cancelOrder(order.getOrderId());

    }

    private Address createAddress(String city, String street, String postalCode) {
        Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        addressRepo.save(address);
        return address;
    }
}
