package com.tantai.assignment.service;


import com.tantai.assignment.domain.*;
import com.tantai.assignment.dto.PaymentRequestDTO;
import com.tantai.assignment.repository.PaymentRepository;
import com.tantai.assignment.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    private OrderService orderService;
    private PaymentRepository paymentRepository;
    private OrderDetailService orderDetailService;
    private ShoppingCartRepository shoppingCartRepository;

    public PaymentService(OrderService orderService, PaymentRepository paymentRepository, OrderDetailService orderDetailService
            , ShoppingCartRepository shoppingCartRepository) {
        this.orderService = orderService;
        this.paymentRepository = paymentRepository;
        this.orderDetailService = orderDetailService;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Transactional
    public Payment makePayment(PaymentRequestDTO payment, Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        order.setOrderStatus(OrderStatus.PAID.toString());
        orderService.updateOrder(order);
        if (validatePayment(order.getId(), payment)) {
            throw new IllegalArgumentException();
        }
        List<OrderDetail> orderDetail = orderDetailService.getOrderDetailByOrderId(order.getId());
        updateCartStatus(orderDetail);
        Payment newPayment = new Payment();
        newPayment.setOrder(order);
        newPayment.setPaymentMethod(payment.getPaymentMethod());
        newPayment.setPaidAmount(payment.getPaidAmount());
        newPayment.setPaidDate(LocalDateTime.now());
        newPayment.setPaymentStatus("PAID");

       return paymentRepository.save(newPayment);
    }

    private void updateCartStatus(List<OrderDetail> orderDetail) {
        for (OrderDetail detail : orderDetail) {
            ShoppingCart shoppingCart = detail.getCard();
            shoppingCart.setCartStatus(CartStatus.PAID.toString());
            shoppingCartRepository.save(shoppingCart);
        }
    }

    private boolean validatePayment(Integer orderId, PaymentRequestDTO paymentRequest) {
        BigDecimal totalAmount = orderService.calculateTotalAmountOrderByOrderId(orderId);
        return (paymentRequest.getPaidAmount().compareTo(totalAmount) < 0);
    }
}
