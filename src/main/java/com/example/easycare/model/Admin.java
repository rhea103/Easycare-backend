package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
@Data

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    private String adminID;

    private String role;
}



