package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {

    // Primary key for the Doctor entity
    @Id
    private String doctorID;

    // Stores the doctor's area of specialization (e.g., Cardiology)
    private String specialization;

    // Stores the doctor's availability (e.g., Mon-Fri 9AM-5PM)
    private String availability;
}
