package com.tantai.assignment.controller;

import com.tantai.assignment.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void getProductByNameShouldNotBeEmpty() {
        List<Product> products = testRestTemplate.getForObject("/product/nike", List.class);
        Assertions.assertFalse(products.isEmpty());
    }
}