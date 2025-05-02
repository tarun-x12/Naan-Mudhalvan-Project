package com.sivanitechtutes.customer_orders.controller;

import com.sivanitechtutes.customer_orders.model.Customer;
import com.sivanitechtutes.customer_orders.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sivani
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "/saveCustomer")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Received customer: " + customer.toString());
        Customer response = customerService.saveCustomer(customer);
        return response;
    }

    /*@PostMapping(value = "saveCustomers")
    public ResponseEntity<List<Customer>> saveCustomers(@RequestBody List<Customer> customers) {
        return (ResponseEntity<List<Customer>>) customerService.saveCustomers(customers);
    }*/

    @DeleteMapping(value = "deleteById/{customerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteCustomerById(@PathVariable("customerId") Long id) {
        log.info("deleteCustomerById called and ID:{}", id);
        String s = customerService.deleteCustomerById(id);
        return s;


    }
}
