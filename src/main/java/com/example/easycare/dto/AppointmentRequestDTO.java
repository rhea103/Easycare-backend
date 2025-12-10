import jakarta.validation.constraints.*;

public class AppointmentRequestDTO {

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotBlank(message = "Appointment date is required")
    private String appointmentDate; // format: yyyy-MM-dd

    @NotBlank(message = "Appointment time is required")
    private String appointmentTime; // format: HH:mm

    @NotBlank(message = "Reason is required")
    @Size(min = 10, message = "Reason must be at least 10 characters")
    private String reason;
}
