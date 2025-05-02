package com.sivanitechtutes.customer_orders.repository;

import com.sivanitechtutes.customer_orders.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sivani
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
