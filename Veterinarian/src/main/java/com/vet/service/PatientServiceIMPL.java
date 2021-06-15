package com.vet.service;

import com.vet.dao.PatientDAO;
import com.vet.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceIMPL implements PatientService{
    private final PatientDAO patientDAO;

    @Autowired
    public PatientServiceIMPL(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    @Override
    public Patient findById(int patientId) {
        return (Patient) patientDAO.findById(patientId);
    }

    @Override
    public void saveOrUpdate(Patient thePatient) {
        patientDAO.saveOrUpdate(thePatient);
    }

    @Override
    public void deleteById(int patientId) {
        patientDAO.deleteById(patientId);
    }
}
