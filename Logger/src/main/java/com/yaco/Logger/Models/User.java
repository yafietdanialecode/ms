package com.yaco.Logger.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String middle_name;
    private String last_name;
    private String password_hash;
    private String phone;
    private int age;
    
}
