import jakarta.validation.constraints.*;

public class MedicalRecordRequestDTO {

    // Stores the ID of the patient and cannot be null
    @NotNull(message = "Patient ID is required")
    private Long patientId;

    // Stores the ID of the doctor and cannot be null
    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    // Stores the diagnosis details and cannot be blank
    @NotBlank(message = "Diagnosis is required")
    private String diagnosis;

    // Stores additional notes for the medical record and cannot be blank
    @NotBlank(message = "Notes cannot be empty")
    private String notes;
}
