package com.example.easycare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRequestDTO {

    // Stores the ID of the patient and cannot be null
    @NotNull(message = "Patient ID is required")
    private Long patientId;

    // Stores the ID of the doctor and cannot be null
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    // Stores the name of the medicine and cannot be blank
    @NotBlank(message = "Medication name is required")
    private String medicineName;

    // Stores the dosage of the medicine and cannot be blank
    @NotBlank(message = "Dosage is required")
    private String dosage;

    // Stores instructions for the prescription, must be at least 10 characters and cannot be blank
    @NotBlank(message = "Instructions are required")
    @Size(min = 10, message = "Instructions must be at least 10 characters")
    private String instructions;
}
