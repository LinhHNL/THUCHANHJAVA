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
@Table(name = "admins")
public class Admin {
    @Id

    @Column(name = "Admin_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminID;
    private String name;
    private String email;
    private String password;
    private int level;

    public Admin(String name, String email, String password, int level) {
        this.name = name;

        this.email = email;
        this.password = password;
        this.level = level;
    }
}
