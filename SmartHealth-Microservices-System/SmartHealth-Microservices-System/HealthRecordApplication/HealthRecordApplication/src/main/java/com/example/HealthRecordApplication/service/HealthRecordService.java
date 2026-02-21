package com.example.HealthRecordApplication.service;



import java.util.List;

import com.example.HealthRecordApplication.dto.HealthRecordRequest;
import com.example.HealthRecordApplication.dto.HealthRecordResponse;

public interface HealthRecordService {

    HealthRecordResponse create(Long patientId,
                                HealthRecordRequest request);

    List<HealthRecordResponse> getByPatient(Long patientId);
}