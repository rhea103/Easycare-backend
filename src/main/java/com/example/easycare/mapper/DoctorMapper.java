package com.example.easycare.mapper;

import com.easycare.dto.DoctorRegisterDTO;
import com.easycare.dto.DoctorResponseDTO;
import com.easycare.model.Doctor;

public class DoctorMapper {

    public static Doctor toEntity(DoctorRegisterDTO dto) {
        Doctor d = new Doctor();
        d.setName(dto.getName());
        d.setEmail(dto.getEmail());
        d.setPassword(dto.getPassword());
        d.setSpecialization(dto.getSpecialization());
        return d;
    }

    public static DoctorResponseDTO toDTO(Doctor d) {
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(d.getId());
        dto.setName(d.getName());
        dto.setEmail(d.getEmail());
        dto.setSpecialization(d.getSpecialization());
        return dto;
    }
}
