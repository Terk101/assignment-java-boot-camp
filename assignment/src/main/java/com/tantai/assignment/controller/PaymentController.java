package com.tantai.assignment.controller;

import com.tantai.assignment.dto.PaymentRequestDTO;
import com.tantai.assignment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO, @RequestParam("orderId") Integer payment) {
        paymentService.makePayment(paymentRequestDTO, payment);
        return ResponseEntity.ok().build();
    }
}
