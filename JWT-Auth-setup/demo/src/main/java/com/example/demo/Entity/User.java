package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    public Long userId;

    public String userName;
    public String password;

}
