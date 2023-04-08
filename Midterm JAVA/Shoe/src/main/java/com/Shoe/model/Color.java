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
@Table(name = "colors")
public class Color {
    @Id

    @Column(name="Color_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ColorId;
    private String Name;

}
