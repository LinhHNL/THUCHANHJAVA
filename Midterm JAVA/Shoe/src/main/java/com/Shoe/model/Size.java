package com.Shoe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "size")
public class Size {
    @Id

    @Column(name = "size_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SizeId;
    private String Name;

}
