package com.tantai.assignment.repository;

import com.tantai.assignment.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Query(
            value = "select * from shopping_cart s " +
                    "INNER JOIN customer c ON  s.customer_id = s.customer_id " +
                    "WHERE s.customer_id = ? AND s.cart_status = 'INITIAL' ",
            nativeQuery = true
    )
    List<ShoppingCart> findShoppingCartDataByCustomerId(Integer customerId);
}