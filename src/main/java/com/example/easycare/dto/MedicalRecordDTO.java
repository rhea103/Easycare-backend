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

    @NotBlank(message = "Patient ID cannot be empty")
    private String patientId;

    @NotBlank(message = "Diagnosis cannot be empty")
    private String diagnosis;

    @NotBlank(message = "Treatment cannot be empty")
    private String treatment;

    @NotNull(message = "Date cannot be null")
    private String date; // or LocalDate if you're using date type
}
