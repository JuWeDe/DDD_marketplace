package com.example.ddd_lab2.Factories;

import com.example.ddd_lab2.Aggregates.Product;
import com.example.ddd_lab2.Aggregates.Promotion;
import com.example.ddd_lab2.Repositories.ProductRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductFactory {

    ProductRepo productRepo;

    public ProductFactory(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(String name, Double price, int amount) {
       Product product = new Product();
       product.setName(name);
       product.setPrice(price);
       product.setAvailableQuantity(amount);
       return productRepo.save(product);
    }
}
