import jakarta.validation.constraints.*;

public class AdminRequestDTO {

    // Stores the name of the admin and cannot be empty
    @NotBlank(message = "Admin name is required")  
    private String name;

    // Stores the admin email and must be a valid email format and not empty
    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    // Stores the admin password and must not be empty along with a minimum length of six characters
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}
