import jakarta.validation.constraints.*;

public class DoctorRequestDTO {

    // Stores the name of the doctor and cannot be blank
    @NotBlank(message = "Doctor name is required")
    private String name;

    // Stores the doctor's email, must be valid and cannot be blank
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    // Stores the doctor's password, must be at least 6 characters and cannot be blank
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    // Stores the doctor's specialization and cannot be blank
    @NotBlank(message = "Specialization is required")
    private String specialization;

    // Stores the doctor's phone number, must be exactly 10 digits
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    // Stores the doctor's years of experience, minimum value must be 1
    @Min(value = 1, message = "Experience cannot be 0")
    private int experienceYears;
}
