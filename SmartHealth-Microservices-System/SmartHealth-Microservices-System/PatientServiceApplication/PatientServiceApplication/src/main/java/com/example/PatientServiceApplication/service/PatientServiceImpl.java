package com.example.PatientServiceApplication.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.PatientServiceApplication.dto.PatientRequest;
import com.example.PatientServiceApplication.dto.PatientResponse;
import com.example.PatientServiceApplication.entity.Patient;
import com.example.PatientServiceApplication.exception.ResourceNotFoundException;
import com.example.PatientServiceApplication.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl
        implements PatientService {

    private final PatientRepository repository;

    @Override
    public PatientResponse create(PatientRequest request) {

        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setEmail(request.getEmail());
System.out.println("pawan");     
Patient saved = repository.save(patient);

        PatientResponse response = new PatientResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setAge(saved.getAge());
        response.setEmail(saved.getEmail());

        return response;
    }

    @Override
    public PatientResponse get(Long id) {

        Patient patient = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setAge(patient.getAge());
        response.setEmail(patient.getEmail());

        return response;
    }
}