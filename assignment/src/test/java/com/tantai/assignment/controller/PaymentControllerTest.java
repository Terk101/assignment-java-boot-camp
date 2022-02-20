package com.tantai.assignment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tantai.assignment.domain.Payment;
import com.tantai.assignment.dto.PaymentRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void makePayment() throws JsonProcessingException {
        PaymentRequestDTO payment = new PaymentRequestDTO();
        payment.setPaymentMethod("CASH");
        payment.setPaidAmount(BigDecimal.valueOf(10000));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payment);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request =
                new HttpEntity<>(json, headers);
        ResponseEntity<Payment> paymentRsp = testRestTemplate.postForEntity("/payment/?orderId=1", request, Payment.class);
        Assertions.assertEquals("PAID", paymentRsp.getBody().getPaymentStatus());
    }
}