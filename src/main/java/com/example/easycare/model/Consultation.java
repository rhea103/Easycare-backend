package com.example.easycare.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;
import lombok.*;
@Data
@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    private String consultationID;

    private Date date;
    private String mode;   // online/offline
    private String status;
}