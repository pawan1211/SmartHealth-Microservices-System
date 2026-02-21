package com.example.HealthRecordApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HealthRecordApplication.entity.HealthRecord;

import java.util.List;

public interface HealthRecordRepository
        extends JpaRepository<HealthRecord, Long> {

    List<HealthRecord> findByPatientId(Long patientId);
}