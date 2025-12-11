import jakarta.validation.constraints.*;

public class AppointmentRequestDTO {

    // Stores the ID of the patient and cannot be null
    @NotNull(message = "Patient ID is required")
    private Long patientId;

    // Stores the ID of the doctor and cannot be null
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    // Stores the date of the appointment in yyyy-MM-dd format and cannot be blank
    @NotBlank(message = "Appointment date is required")
    private String appointmentDate; // format: yyyy-MM-dd

    // Stores the time of the appointment in HH:mm format and cannot be blank
    @NotBlank(message = "Appointment time is required")
    private String appointmentTime; // format: HH:mm

    // Stores the reason for the appointment, must be at least 10 characters and cannot be blank
    @NotBlank(message = "Reason is required")
    @Size(min = 10, message = "Reason must be at least 10 characters")
    private String reason;
}
