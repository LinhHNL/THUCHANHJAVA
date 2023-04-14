package com.example.lab8_ex2.Model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  Name;
    private String Email;
    private String Address;
    private  String	Phone;
}
