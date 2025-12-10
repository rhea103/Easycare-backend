package c.exampleom.easycare.mapper;

import com.easycare.dto.MedicalRecordDTO;
import com.easycare.model.MedicalRecord;

public class MedicalRecordMapper {

    public static MedicalRecordDTO toDTO(MedicalRecord record) {
        MedicalRecordDTO dto = new MedicalRecordDTO();
        dto.setId(record.getId());
        dto.setPatientId(record.getPatientId());
        dto.setDoctorId(record.getDoctorId());
        dto.setDiagnosis(record.getDiagnosis());
        dto.setPrescription(record.getPrescription());
        dto.setDateCreated(record.getDateCreated());
        return dto;
    }
}
