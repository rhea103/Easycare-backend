package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    // Primary key for the User entity
    @Id
    private String userID;

    // Stores the user's full name
    private String name;

    // Stores the user's email
    private String email;

    // Stores the user's password 
    private String password;

    // Stores the role of the user (e.g., ADMIN, DOCTOR, PATIENT)
    private String role;
}
