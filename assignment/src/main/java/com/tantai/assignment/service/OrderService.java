package com.tantai.assignment.service;

import com.tantai.assignment.domain.Order;
import com.tantai.assignment.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public BigDecimal calculateTotalAmountOrderByOrderId(Integer orderId) {
        return orderRepository.calculateTotalAmountOrderByOrderId(orderId);
    }
}
