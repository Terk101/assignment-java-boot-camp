package com.tantai.assignment.service;

import com.tantai.assignment.domain.Payment;
import com.tantai.assignment.dto.PaymentRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class PaymentServiceTest {
    @Autowired
    PaymentService paymentService;

    @Test
    void makePayment() {
        PaymentRequestDTO payment = new PaymentRequestDTO();
        payment.setPaymentMethod("CASH");
        payment.setPaidAmount(BigDecimal.valueOf(3360));
        Payment newPayment = paymentService.makePayment(payment, 1);
        Assertions.assertEquals("PAID", newPayment.getPaymentStatus());
    }
}