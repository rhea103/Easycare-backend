package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
@Table(name = "admins")
public class Admin {

    // Primary key for the Admin entity
    @Id
    private String adminID;

    // Stores the role of the admin (e.g., ADMIN)
    private String role;
}


