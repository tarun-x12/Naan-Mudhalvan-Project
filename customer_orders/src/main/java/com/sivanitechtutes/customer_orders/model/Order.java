package com.sivanitechtutes.customer_orders.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author Sivani
 */

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Product name is required")
    //@Column(nullable = false)
    private String product;

    //@NotNull(message = "Quantity is required")
    //@Column(nullable = false)
    private int quantity;

    //@NotNull(message = "Price is required")
    //@Column(nullable = false)
    private Double price;


    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) //customer_id is FK
    //@JsonIgnore
    // @JsonManagedReference
    @JsonBackReference
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
