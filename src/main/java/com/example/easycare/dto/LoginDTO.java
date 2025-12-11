package com.example.easycare.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    // Stores the user's email, must be a valid email format and cannot be empty
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    // Stores the user's password and cannot be empty
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
