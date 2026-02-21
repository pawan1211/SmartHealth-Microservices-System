package com.example.PatientServiceApplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import com.example.PatientServiceApplication.dto.PatientRequest;
import com.example.PatientServiceApplication.dto.PatientResponse;
import com.example.PatientServiceApplication.service.PatientService;


@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @PostMapping
    public ResponseEntity<PatientResponse> create(
            @Valid @RequestBody PatientRequest request) {

        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> get(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.get(id));
    }
}