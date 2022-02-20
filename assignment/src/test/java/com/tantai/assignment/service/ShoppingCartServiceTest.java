package com.tantai.assignment.service;

import com.tantai.assignment.domain.*;
import com.tantai.assignment.dto.ProductToCartDTO;
import com.tantai.assignment.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ShoppingCartServiceTest {
    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void addProductToCartShouldGetCartStatusInitial() {
        ProductToCartDTO productDTO = new ProductToCartDTO();
        productDTO.setProductId(1);
        productDTO.setQty(3);

        List<ProductToCartDTO> productToCartDTOS = new ArrayList<>();
        productToCartDTOS.add(productDTO);

        List<ShoppingCart> shoppingCartReturn = shoppingCartService
                .addProductToCart(productToCartDTOS, 1);

        Assertions.assertEquals(CartStatus.INITIAL.toString(), shoppingCartReturn.get(0).getCartStatus());
    }

    @Test
    void getShoppingCardDataByCustomerId() {
        ProductToCartDTO productDTO = new ProductToCartDTO();
        productDTO.setProductId(2);
        productDTO.setQty(3);

        List<ProductToCartDTO> productToCartDTOS = new ArrayList<>();
        productToCartDTOS.add(productDTO);

        Customer customer = new Customer();
        customer.setCustomerName("Test Test");
        CustomerContact customerContact = new CustomerContact();
        customerContact.setDistrict("Test District");
        customerContact.setEmail("");
        customerContact.setHouseNo("222");
        customerContact.setPhoneNo("045");
        customerContact.setZipCode("101");
        customerContact.setProvince("test");
        customerContact.setSoi("main");
        customerContact.setSubdistrict("sub");
        customer.setCustomerContact(customerContact);
        customer = customerRepository.save(customer);

        shoppingCartService.addProductToCart(productToCartDTOS, customer.getId1());
        List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCardDataByCustomerId(customer.getId1());
        Assertions.assertFalse(shoppingCarts.isEmpty());
    }

    @Test
    void checkoutProduct() {
        ProductToCartDTO productDTO = new ProductToCartDTO();
        productDTO.setProductId(3);
        productDTO.setQty(2);

        List<ProductToCartDTO> productToCartDTOS = new ArrayList<>();
        productToCartDTOS.add(productDTO);

        Customer customer = new Customer();
        customer.setCustomerName("Test Test");
        CustomerContact customerContact = new CustomerContact();
        customerContact.setDistrict("Test District");
        customerContact.setEmail("");
        customerContact.setHouseNo("222");
        customerContact.setPhoneNo("045");
        customerContact.setZipCode("101");
        customerContact.setProvince("test");
        customerContact.setSoi("main");
        customerContact.setSubdistrict("sub");
        customer.setCustomerContact(customerContact);
        customer = customerRepository.save(customer);

        List<ShoppingCart> shoppingCarts = shoppingCartService.addProductToCart(productToCartDTOS, customer.getId1());
        List<Integer> shoppingCartId = shoppingCarts.stream().map(ShoppingCart::getId).collect(Collectors.toList());
        List<OrderDetail> orderDetails = shoppingCartService.checkoutProduct(shoppingCartId, customer.getId1());
        Assertions.assertFalse(orderDetails.isEmpty());
    }
}