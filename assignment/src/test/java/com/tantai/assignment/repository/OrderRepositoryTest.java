package com.tantai.assignment.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void calculateTotalAmountOrderByOrderIdShouldReturnTotalAmount3360Baht() {
        BigDecimal totalAmount = orderRepository.calculateTotalAmountOrderByOrderId(1);
        Assertions.assertEquals(BigDecimal.valueOf(3360), totalAmount);
    }
}