package com.example.easycare.mapper;

import com.example.easycare.dto.AppointmentRequestDTO;
import com.example.easycare.dto.AppointmentResponseDTO;
import com.example.easycare.model.Appointment;

public class AppointmentMapper {

    public static Appointment toEntity(AppointmentRequestDTO dto) {
        Appointment a = new Appointment();
        a.setPatientId(dto.getPatientId());
        a.setDoctorId(dto.getDoctorId());
        a.setDate(dto.getDate());
        a.setTime(dto.getTime());
        a.setStatus("PENDING"); // default status
        return a;
    }

    public static AppointmentResponseDTO toDTO(Appointment a, String patientName, String doctorName) {
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

