package com.tantai.assignment.service;

import com.tantai.assignment.domain.OrderDetail;
import com.tantai.assignment.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getOrderDetailByOrderId(Integer orderId) {
        return orderDetailRepository.findOrderDetailByOrderId(orderId);
    }
}
