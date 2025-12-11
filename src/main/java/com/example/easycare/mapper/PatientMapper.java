package com.example.easycare.mapper;

import com.example.easycare.dto.PatientRegisterDTO;
import com.example.easycare.dto.PatientResponseDTO;
import com.example.easycare.model.Patient;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientMapper {

    // Converts a PatientRegisterDTO to a Patient entity
    public Patient toEntity(PatientRegisterDTO dto) {
        Patient p = new Patient();
        p.setName(dto.getName());
        p.setEmail(dto.getEmail());
        p.setPassword(dto.getPassword());
        p.setPhone(dto.getPhone());
        return p;
    }

    // Converts a Patient entity to a PatientResponseDTO
    public PatientResponseDTO toDTO(Patient p) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setEmail(p.getEmail());
        dto.setPhone(p.getPhone());
        return dto;
    }
}
