package com.tantai.assignment.repository;

import com.tantai.assignment.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(
            value = "SELECT * FROM order_detail rd " +
                    "INNER JOIN customer_order c ON  c.order_id = rd.order_id " +
                    "WHERE rd.order_id = ?  ",
            nativeQuery = true
    )
    List<OrderDetail> findOrderDetailByOrderId(Integer orderId);
}