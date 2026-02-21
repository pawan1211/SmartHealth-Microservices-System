package com.example.PatientServiceApplication.service;

import com.example.PatientServiceApplication.dto.PatientRequest;
import com.example.PatientServiceApplication.dto.PatientResponse;

public interface PatientService {

    PatientResponse create(PatientRequest request);

    PatientResponse get(Long id);
}