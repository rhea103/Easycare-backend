package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
@Data
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    private String doctorID;

    private String specialization;
    private String availability;
}
