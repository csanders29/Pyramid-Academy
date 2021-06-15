package com.vet.dao;

import com.vet.entity.Patient;

import java.util.List;

public interface PatientDAO {
    List<Patient> findAll();
    Object findById(int theId);
    void saveOrUpdate(Patient thePatient);
    void deleteById(int theId);
}
