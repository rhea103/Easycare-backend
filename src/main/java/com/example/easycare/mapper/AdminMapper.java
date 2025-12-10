package com.example.easycare.mapper;

import com.example.easycare.dto.AdminRegisterDTO;
import com.example.easycare.dto.AdminResponseDTO;
import com.example.easycare.model.Admin;

public class AdminMapper {

    public static Admin toEntity(AdminRegisterDTO dto) {
        Admin a = new Admin();
        a.setUsername(dto.getUsername());
        a.setPassword(dto.getPassword());
        return a;
    }

    public static AdminResponseDTO toDTO(Admin a) {
        AdminResponseDTO dto = new AdminResponseDTO();
        dto.setId(a.getId());
        dto.setUsername(a.getUsername());
        return dto;
    }
}

