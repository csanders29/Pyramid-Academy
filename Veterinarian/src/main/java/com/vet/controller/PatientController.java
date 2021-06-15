package com.vet.controller;

import com.vet.entity.Patient;
import com.vet.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(@Qualifier("patientServiceIMPL")PatientService patientService) {
        this.patientService = patientService;
    }

    //http://localhost:8080/retrieveAllPatients
    @GetMapping("/retrieveAllPatients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    //This is a POST request to add a new patient.
    //http://localhost:8080/addPatient
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient thePatient) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        thePatient.setId(0);

        //This will call the patientDqoImpl.save method to save a new patient
        //through the patientService interface SPRING
        patientService.saveOrUpdate(thePatient);
        return thePatient;
    }

    //This is a PUT request to update an existing patient.
    //http://localhost:8080/updatePatient
    @PutMapping("/updatePatient")
    public Patient updatePatient(@RequestBody Patient updatePatient) {
        //No thepatient.setId(0); this will execute an update instead of a create
        patientService.saveOrUpdate(updatePatient);
        return updatePatient;
    }

    //This is a DELETE request to delete an existing patient.
    //http://localhost:8080/deletepatient/1
    @DeleteMapping("/deletePatient/{patientId}")
    public String deletePatient(@PathVariable int patientId) {
        //This will execute the deleteByID.
        patientService.deleteById(patientId);
        return "Deleted patient id : " + patientId;
    }

    //http://localhost:8080/getPatient/2
    @GetMapping("/getPatient/{patientId}")
    public Patient getUser(@PathVariable int patientId) {
        Patient patient = patientService.findById(patientId);
        return patient;
    }
}
