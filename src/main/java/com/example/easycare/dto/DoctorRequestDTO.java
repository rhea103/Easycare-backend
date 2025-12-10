
import jakarta.validation.constraints.*;

public class DoctorRequestDTO {

    @NotBlank(message = "Doctor name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    @Min(value = 1, message = "Experience cannot be 0")
    private int experienceYears;
}
