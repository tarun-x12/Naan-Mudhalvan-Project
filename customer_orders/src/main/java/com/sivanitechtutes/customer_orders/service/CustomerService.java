package com.sivanitechtutes.customer_orders.service;

import com.sivanitechtutes.customer_orders.model.Customer;
import com.sivanitechtutes.customer_orders.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sivani
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public String deleteCustomerById(Long c_id){
        Optional<Customer> customerOptional = customerRepository.findById(c_id);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(c_id);
            return "Customer with ID " + c_id + " deleted successfully";

        } else {
            throw new RuntimeException("Customer with ID " + c_id + " not found.");
        }

    }

    /*public List<Customer> saveCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }*/
}
