package com.Shoe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
    @Id

@Column(name = "Brand_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BrandId;
    private String Name;
    @JsonManagedReference
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)

    private Set<Product> listOfProducts;
}
