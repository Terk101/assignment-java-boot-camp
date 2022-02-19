package com.tantai.assignment.repository;

import com.tantai.assignment.domain.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void findOrderDetailByOrderIdShouldNotEmpty() {
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrderId(1);
        Assertions.assertFalse(orderDetails.isEmpty());
    }
}