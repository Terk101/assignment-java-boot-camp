package com.tantai.assignment.repository;

import com.tantai.assignment.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductByIdShouldNotBeNull() {
        Optional<Product> product = productRepository.findById(1);
        Assertions.assertNotNull(product.orElse(null));
    }

    @Test
    void findProductByNameShouldNotBeNull() {
        List<Product> products = productRepository.findByProductNameContainingIgnoreCase("nike");
        Assertions.assertFalse(products.isEmpty());
    }
}