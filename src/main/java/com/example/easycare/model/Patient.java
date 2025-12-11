package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    // Primary key for the Patient entity
    @Id
    private String patientID;

    // Stores the age of the patient
    private int age;

    // Stores the gender of the patient (e.g., Male, Female, Other)
    private String gender;

    // Stores contact information such as phone or email
    private String contactInfo;
}
