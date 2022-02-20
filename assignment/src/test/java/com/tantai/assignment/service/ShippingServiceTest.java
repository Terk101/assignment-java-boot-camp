package com.tantai.assignment.service;

import com.tantai.assignment.domain.Shipping;
import com.tantai.assignment.dto.ShippingRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShippingServiceTest {
    @Autowired
    ShippingService shippingService;

    @Test
    void makeShipment() {
        ShippingRequestDTO shippingRequest = new ShippingRequestDTO();
        shippingRequest.setAddress("test address");
        shippingRequest.setDistrict("test");
        shippingRequest.setProvince("test_province");
        shippingRequest.setEmail("test@email.com");
        shippingRequest.setPostCode("10210");
        shippingRequest.setPhoneNo("0133333");
        Shipping shipping = shippingService.makeShipment(shippingRequest, 1, 1);
        Assertions.assertEquals("test@email.com", shipping.getEmail());
    }
}