package com.sivanitechtutes.customer_orders.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Sivani
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "Mobile number is required")
    @Column(nullable = false)
    private Long mobile;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders;

    /**
     * Ensure customer id's are linked to corresponding orders automatically
     * @param orders orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
        if (orders != null) {
            for (Order order : orders) {
                order.setCustomer(this); // Automatically set the customer in each order
            }
        }
    }


   /*public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Ravi", "Ravi@gmail.com", 123456789L, new ArrayList<>());
        Customer customer2 = new Customer(2, "Riya", "Riya@gmail.com", 234567891L, new ArrayList<>());
        Customer customer3 = new Customer(3, "sivani", "sivani@gmail.com", 345678912L, new ArrayList<>());
        log.info("customer-1:{}, \ncustomer-2:{}, \ncustomer-3:{}", customer1, customer2, customer3);
    }*/

}
