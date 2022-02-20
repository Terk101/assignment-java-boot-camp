package com.tantai.assignment.controller;

import com.tantai.assignment.dto.ShippingRequestDTO;
import com.tantai.assignment.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping("/shipment")
    public ResponseEntity makeShipment(@RequestBody ShippingRequestDTO shippingRequest
            , @RequestParam("customerId") Integer customerId
            , @RequestParam("orderId") Integer orderId) {

        shippingService.makeShipment(shippingRequest, customerId, orderId);
        return ResponseEntity.ok().build();
    }
}