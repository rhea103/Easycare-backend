package com.example.easycare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "consultations")
public class Consultation {

    // Primary key for the Consultation entity
    @Id
    private String consultationID;

    // Stores the date of the consultation
    private Date date;

    // Stores the mode of the consultation: online or offline
    private String mode;

    // Stores the current status of the consultation (e.g., PENDING, COMPLETED)
    private String status;
}
