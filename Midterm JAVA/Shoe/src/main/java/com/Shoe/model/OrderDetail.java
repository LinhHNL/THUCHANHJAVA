package com.Shoe.model;

import com.Shoe.dao.BrandRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="product_id ")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Product product;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="Order_ID ")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Order order;

    @ManyToOne
    @JoinColumn(name ="color_ID ")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Color color;
    @ManyToOne
    @JoinColumn(name ="size_ID ")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Size size;
    private int Number;

    private double Price;

    public OrderDetail(Order order ,Product product, Color color,Size size,int number,double price) {
        this.order = order;
        this.color = color;
        this.size = size;
        this.Number = number;
        this.Price = price;
        this.product = product;
    }
}
