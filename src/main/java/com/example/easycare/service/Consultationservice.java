package com.example.easycare.service;

import com.example.easycare.dto.ConsultationRequestDTO;
import com.example.easycare.model.Consultation;
import com.example.easycare.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// Implementation of the ConsultationService interface
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    // Schedule a new consultation using the request DTO
    @Override
    public Consultation scheduleConsultation(ConsultationRequestDTO dto) {
        Consultation c = new Consultation();
        c.setPatientId(dto.getPatientId());
        c.setDoctorId(dto.getDoctorId());
        c.setDateTime(dto.getDateTime()); // Assumes Consultation has a dateTime field
        c.setStatus("Scheduled");          // Default status when scheduling
        return consultationRepository.save(c);
    }

    // Start an existing consultation by updating its status
    @Override
    public String startConsultation(String id) {
        Consultation c = consultationRepository.findById(id).orElse(null);
        if (c == null) return "Consultation not found";
        c.setStatus("In Progress");
        consultationRepository.save(c);
        return "Consultation started";
    }

    // End an existing consultation by updating its status
    @Override
    public String endConsultation(String id) {
        Consultation c = consultationRepository.findById(id).orElse(null);
        if (c == null) return "Consultation not found";
        c.setStatus("Completed");
        consultationRepository.save(c);
        return "Consultation ended";
    }
}
