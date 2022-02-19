package com.tantai.assignment.service;

import com.tantai.assignment.domain.Product;
import com.tantai.assignment.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(Integer productId) {
        return productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
    }

    public List<Product> getProductByName(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }
}
