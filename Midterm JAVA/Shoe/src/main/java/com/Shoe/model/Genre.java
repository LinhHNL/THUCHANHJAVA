package com.Shoe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id

@Column(name = "genre_id ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId ;
    private String Name;
    @JsonManagedReference

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)

    private Set<Product> listOfProducts;
}
