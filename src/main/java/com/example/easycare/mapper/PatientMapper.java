package com.example.easycare.mapper;

import com.example.easycare.dto.PatientRegisterDTO;
import com.example.easycare.dto.PatientResponseDTO;
import com.example.easycare.model.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientRegisterDTO dto) {
        Patient p = new Patient();
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setPassword(dto.getPassword());
        p.setPhone(dto.getPhone());
        return p;
    }

    public static PatientResponseDTO toDTO(Patient p) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setEmail(p.getEmail());
        dto.setPhone(p.getPhone());
        return dto;
    }
}
