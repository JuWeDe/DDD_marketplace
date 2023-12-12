package com.example.ddd_lab2.Services;


import com.example.ddd_lab2.Aggregates.Product;
import com.example.ddd_lab2.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepo productRepository;

    public Product createProduct(String name, int availableQuantity) {
        Product product = new Product();
        product.setName(name);
        product.setAvailableQuantity(availableQuantity);
        return productRepository.saveAndFlush(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {

        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }
    public void updateInventory(Long productId, int quantity) {
        Optional<Product> product = productRepository.findById(productId);

        if (product != null) {
            product.get().setAvailableQuantity(quantity);

        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}