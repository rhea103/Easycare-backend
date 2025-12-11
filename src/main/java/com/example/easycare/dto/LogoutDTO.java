package com.example.easycare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogoutDTO {
   
    // Stores the user id  and cannot be empty
    @NotBlank(message = "User ID cannot be empty")
    private String userId;
}
