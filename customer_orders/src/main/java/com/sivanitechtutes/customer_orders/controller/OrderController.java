package com.sivanitechtutes.customer_orders.controller;
import com.sivanitechtutes.customer_orders.model.Order;
import com.sivanitechtutes.customer_orders.service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sivani
 */

//@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    @GetMapping(value = "getAllOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order> getAllOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        log.info("all orders from getAllOrders method:{}", allOrders );
        return allOrders;
    }

    @PostMapping(value = "saveOrder")
    public Order saveOrder(@Valid @RequestBody Order order) {
        log.info("Order request body:{}", order);
        return orderService.saveOrder(order);
    }

    @DeleteMapping(value = "deleteById/{orderId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteOrderById(@PathVariable("orderId") Long id) {
        log.info("deleteOrderById called and ID:{}", id);
        ResponseEntity<String> deletedOrderById = orderService.deleteOrderById(id);
        return deletedOrderById;
    }


}
