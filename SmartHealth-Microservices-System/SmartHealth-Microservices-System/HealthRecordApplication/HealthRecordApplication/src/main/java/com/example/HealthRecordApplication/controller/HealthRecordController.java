package com.example.HealthRecordApplication.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.HealthRecordApplication.dto.HealthRecordRequest;
import com.example.HealthRecordApplication.dto.HealthRecordResponse;
import com.example.HealthRecordApplication.service.HealthRecordService;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;



import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class HealthRecordController {

    private final HealthRecordService service;

    @PostMapping("/{patientId}")
    public ResponseEntity<HealthRecordResponse> create(
            @PathVariable Long patientId,
            @Valid @RequestBody HealthRecordRequest request) {

        return ResponseEntity.ok(
                service.create(patientId, request));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<HealthRecordResponse>> get(
            @PathVariable Long patientId) {

        return ResponseEntity.ok(
                service.getByPatient(patientId));
    }
}