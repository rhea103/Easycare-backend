package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    private String patientID;

    private int age;
    private String gender;
    private String contactInfo;
}
