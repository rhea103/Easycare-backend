package com.example.easycare.mapper;

import com.example.easycare.dto.AdminRegisterDTO;
import com.example.easycare.dto.AdminResponseDTO;
import com.example.easycare.model.Admin;

public class AdminMapper {

    // Converts an AdminRegisterDTO object to an Admin entity
    // This is used when creating or saving an Admin in the database
    public static Admin toEntity(AdminRegisterDTO dto) {
        Admin a = new Admin();
        a.setUsername(dto.getUsername());
        a.setPassword(dto.getPassword());
        return a;
    }

    // Converts an Admin entity to an AdminResponseDTO object
    // This is used when sending Admin data back in a response
    public static AdminResponseDTO toDTO(Admin a) {
        AdminResponseDTO dto = new AdminResponseDTO();
        dto.setId(a.getId());
        dto.setUsername(a.getUsername());
        return dto;
    }
}

