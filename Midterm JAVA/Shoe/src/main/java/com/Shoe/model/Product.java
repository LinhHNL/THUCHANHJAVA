package com.Shoe.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id

    @Column(name = "Product_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;
    private String Name;
    private Double Price;
    private String Description;
    private String URLImage;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="genre_id ")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Genre genre;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="Brand_ID")
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Brand brand;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "colordetail",
            joinColumns = {
                    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Color_ID", referencedColumnName = "Color_ID"),
            }
    )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Collection<Color> colors;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "sizedetail",
            joinColumns = {
                    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Size_ID", referencedColumnName = "Size_ID"),
            }
    )
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude
    private Collection<Size> sizes;

;

}
