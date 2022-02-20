package com.tantai.assignment.service;

import com.tantai.assignment.domain.Customer;
import com.tantai.assignment.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void getCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerName("นาย สมมุติ ทดสอบ");
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        Customer customerData = customerService.getCustomerById(1);
        Assertions.assertEquals("นาย สมมุติ ทดสอบ", customerData.getCustomerName());
    }
}