package com.sivanitechtutes.customer_orders.repository;

import com.sivanitechtutes.customer_orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sivani
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
