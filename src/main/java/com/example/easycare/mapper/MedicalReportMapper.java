package com.example.easycare.mapper;

import com.easycare.dto.MedicalRecordDTO;
import com.easycare.model.MedicalRecord;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MedicalRecordMapper {

    // Converts a MedicalRecord entity to a MedicalRecordDTO
    public MedicalRecordDTO toDTO(MedicalRecord record) {
        MedicalRecordDTO dto = new MedicalRecordDTO();
        dto.setId(record.getId());
        dto.setPatientId(record.getPatientId());
        dto.setDoctorId(record.getDoctorId());
        dto.setDiagnosis(record.getDiagnosis());
        dto.setPrescription(record.getPrescription());
        dto.setDate(record.getDateCreated());
        return dto;
    }
}
