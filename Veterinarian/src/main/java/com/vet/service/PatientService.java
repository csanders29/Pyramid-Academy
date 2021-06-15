package com.vet.service;

import com.vet.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findById(int patientId);
    void saveOrUpdate(Patient thePatient);
    void deleteById(int patientId);
}
