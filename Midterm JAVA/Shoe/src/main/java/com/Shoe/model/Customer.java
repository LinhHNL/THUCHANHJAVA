package com.Shoe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id

    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String email;
    private String address;
    private String password;
    private String phone;

    public Customer(String name, String email, String address, String password, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.phone = phone;
    }
}
