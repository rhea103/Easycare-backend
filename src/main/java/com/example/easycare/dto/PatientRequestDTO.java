import jakarta.validation.constraints.*;

public class PatientRequestDTO {

    // Stores the patient's name and cannot be blank
    @NotBlank(message = "Patient name is required")
    private String name;

    // Stores the patient's email, must be valid and cannot be blank
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    // Stores the patient's password, must be 6–20 characters and cannot be blank
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be 6–20 characters")
    private String password;

    // Stores the patient's phone number, must be exactly 10 digits
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    // Stores the patient's age, minimum value must be 1
