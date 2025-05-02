package com.sivanitechtutes.customer_orders.service;

import com.sivanitechtutes.customer_orders.model.Order;
import com.sivanitechtutes.customer_orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sivani
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        return allOrders;
    }

    public Order saveOrder(Order order) {
        Order savedOrders = orderRepository.save(order);
        return savedOrders;
    }

    public ResponseEntity<String> deleteOrderById(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok("Order with ID " + orderId + " deleted successfully.");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with ID " + orderId + " not found.");
        }

    }
}
