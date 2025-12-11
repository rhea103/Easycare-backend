package com.example.easycare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDTO {

    // Stores the ID of the patient and cannot be empty
    @NotBlank(message = "Patient ID cannot be empty")
    private String patientId;

    // Stores the diagnosis details and cannot be empty
    @NotBlank(message = "Diagnosis cannot be empty")
    private String diagnosis;

    // Stores the treatment details and cannot be empty
    @NotBlank(message = "Treatment cannot be empty")
    private String treatment;

    // Stores the date of the medical record, cannot be null
    private String date; // or LocalDate if you're using date type
}
