package com.example.easycare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationRequestDTO {

    @NotBlank(message = "Patient ID cannot be empty")
    private String patientId;

    @NotBlank(message = "Doctor ID cannot be empty")
    private String doctorId;

    @NotBlank(message = "Date cannot be empty")
    private String date;

    @NotBlank(message = "Time cannot be empty")
    private String time;
}
