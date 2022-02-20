package com.tantai.assignment.service;


import com.tantai.assignment.domain.*;
import com.tantai.assignment.dto.ShippingRequestDTO;
import com.tantai.assignment.repository.ShippingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ShippingService {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ShippingRepository shippingRepository;

    public ShippingService(CustomerService customerService, OrderService orderService, ShippingRepository shippingRepository) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.shippingRepository = shippingRepository;
    }

    @Transactional
    public Shipping makeShipment(ShippingRequestDTO shippingRequestDTO, Integer customerId, Integer orderId) {
        if (Objects.nonNull(shippingRequestDTO)) {
            Shipping shipping = new Shipping();
            Customer customer = customerService.getCustomerById(customerId);
            Order order = orderService.getOrderById(orderId);
            order.setOrderStatus(OrderStatus.SHIPPING.toString());
            order = orderService.updateOrder(order);
            shipping.setCustomer(customer);
            shipping.setOrder(order);
            if (shippingRequestDTO.getUseCurrentAddress()) {
                CustomerContact customerContact = customer.getCustomerContact();
                shipping.setAddress("House no." + customerContact.getHouseNo() + "  Soi." + customerContact.getSoi());
                shipping.setDistrict(customerContact.getDistrict());
                shipping.setProvince(customerContact.getProvince());
                shipping.setPostcode(customerContact.getZipCode());
                shipping.setEmail(customerContact.getEmail());
                shipping.setPhoneNo(customerContact.getPhoneNo());
            } else {
                shipping.setAddress(shippingRequestDTO.getAddress());
                shipping.setDistrict(shippingRequestDTO.getDistrict());
                shipping.setProvince(shippingRequestDTO.getProvince());
                shipping.setPostcode(shippingRequestDTO.getPostCode());
                shipping.setEmail(shippingRequestDTO.getEmail());
                shipping.setPhoneNo(shippingRequestDTO.getPhoneNo());
            }
            return shippingRepository.save(shipping);
        }
        throw new IllegalArgumentException("Shipping can't null");
    }
}
