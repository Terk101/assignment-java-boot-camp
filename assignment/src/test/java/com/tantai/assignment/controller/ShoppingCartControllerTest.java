package com.tantai.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tantai.assignment.dto.ProductToCartDTO;
import com.tantai.assignment.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoppingCartControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @Test
    void addProductToCart() throws JsonProcessingException {
        ProductToCartDTO productDTO = new ProductToCartDTO();
        productDTO.setProductId(1);
        productDTO.setQty(2);
        ProductToCartDTO productDTO2 = new ProductToCartDTO();
        productDTO2.setProductId(2);
        productDTO2.setQty(2);
        List<ProductToCartDTO> products = new ArrayList<>();
        products.add(productDTO);
        products.add(productDTO2);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(products);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request =
                new HttpEntity<>(json, headers);

        ResponseEntity shoppingCarts = testRestTemplate.postForEntity("/card/?customerId=1", request, List.class);
        Assertions.assertEquals(HttpStatus.OK, shoppingCarts.getStatusCode());
    }

    @Test
    void testAddProductToCart() {
    }
}