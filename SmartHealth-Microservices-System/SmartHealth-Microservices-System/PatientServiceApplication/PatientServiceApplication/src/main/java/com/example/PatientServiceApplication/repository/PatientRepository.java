package com.example.PatientServiceApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PatientServiceApplication.entity.Patient;

public interface PatientRepository
extends JpaRepository<Patient, Long> {

Optional<Patient> findByEmail(String email);
}