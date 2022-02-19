package com.tantai.assignment.repository;

import com.tantai.assignment.domain.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
class ShoppingCartRepositoryTest {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    void findShoppingCartDataByCustomerIdShouldNotEmpty() {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findShoppingCartDataByCustomerId(1);
        Assertions.assertFalse(!shoppingCarts.isEmpty());
    }
}