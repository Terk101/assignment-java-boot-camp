package com.tantai.assignment.repository;

import com.tantai.assignment.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void getCustomerByIdShouldNotNull() {
       Optional<Customer> customer = customerRepository.findById(1);
       Assertions.assertNotNull(customer.orElse(null));
    }
}