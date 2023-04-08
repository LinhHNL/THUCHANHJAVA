package com.Shoe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "Order_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;

    @ManyToOne
    @JoinColumn(name ="Customer_Id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;
    private Double TotalPrice;
    private LocalDateTime Date;
    private String address;

    private  int status;
    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> listOfOrderDetails;
}
