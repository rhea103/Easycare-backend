package com.example.easycare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationRequestDTO {

    // Stores the ID of the patient and cannot be empty
    @NotBlank(message = "Patient ID cannot be empty")
    private String patientId;

    // Stores the ID of the doctor and cannot be empty
    @NotBlank(message = "Doctor ID cannot be empty")
    private String doctorId;

    // Stores the date of the consultation and cannot be empty
    private String date;

    // Stores the time of the consultation and cannot be empty
    private String time;
}
