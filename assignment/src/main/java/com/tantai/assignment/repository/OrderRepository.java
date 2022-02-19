package com.tantai.assignment.repository;

import com.tantai.assignment.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(
            value = "SELECT SUM(c.total_cost) FROM shopping_cart c " +
                    "INNER JOIN order_detail d ON d.card_id = c.card_id " +
                    "INNER JOIN customer_order cr ON cr.order_id = d.order_id " +
                    "WHERE cr.order_id = ? AND c.cart_status = 'ORDERED'",
            nativeQuery = true
    )
    BigDecimal calculateTotalAmountOrderByOrderId(Integer orderId);
}