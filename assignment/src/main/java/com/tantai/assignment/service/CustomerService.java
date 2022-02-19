package com.tantai.assignment.service;


import com.tantai.assignment.domain.Customer;
import com.tantai.assignment.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException());
        return customer;
    }
}
