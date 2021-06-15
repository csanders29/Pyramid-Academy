package com.vet.dao;

import com.vet.entity.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PatientIMPL implements PatientDAO{

    private final EntityManager entityManager;

    @Autowired
    public PatientIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Patient> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Patient> myQuery = currentSession.createQuery("from Patient");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Patient findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return (currentSession.get(Patient.class, theId));
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Patient thePatient) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePatient);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Patient myPatient = currentSession.get(Patient.class, theId);
        currentSession.delete(myPatient);
    }
}
