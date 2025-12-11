package com.example.easycare.mapper;

import com.example.easycare.dto.AppointmentRequestDTO;
import com.example.easycare.dto.AppointmentResponseDTO;
import com.example.easycare.model.Appointment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AppointmentMapper {

    // Converts an AppointmentRequestDTO to an Appointment entity
    public Appointment toEntity(AppointmentRequestDTO dto) {
        Appointment a = new Appointment();
        a.setPatientId(dto.getPatientId());
        a.setDoctorId(dto.getDoctorId());
        a.setDate(dto.getDate());
        a.setTime(dto.getTime());
        a.setStatus("PENDING"); // default status
        return a;
    }

    // Converts an Appointment entity to an AppointmentResponseDTO
    // Includes patientName and doctorName for better API response readability
    public AppointmentResponseDTO toDTO(Appointment a, String patientName, String doctorName) {
        AppointmentResponseDTO dto = new AppointmentResponseDTO();
        dto.setId(a.getId());
        dto.setPatientId(a.getPatientId());
        dto.setDoctorId(a.getDoctorId());
        dto.setPatientName(patientName);
        dto.setDoctorName(doctorName);
        dto.setDate(a.getDate());
        dto.setTime(a.getTime());
        dto.setStatus(a.getStatus());
        return dto;
    }
}

