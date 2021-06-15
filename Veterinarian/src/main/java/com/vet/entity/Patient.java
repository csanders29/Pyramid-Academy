package com.vet.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "patient_name") //This will map the firstName field to the column named first_name in the table.
    private String patient_name;

    @Column(name = "breed") //This will map the firstName field to the column named first_name in the table.
    private String breed;

    @Column(name = "owner_first_name") //This will map the jobTitle field to the column named job_title in the table.
    private String owner_first_name;

    @Column(name = "owner_last_name") //This will map the lastName field to the column named last_name in the table.
    private String owner_last_name;

    @Column(name = "owner_email") //This will map the email field to the column named email in the table.
    private String owner_email;

    //default constructor
    public Patient() {
    }

    public Patient(String patient_name, String breed, String owner_first_name, String owner_last_name, String owner_email) {
        this.patient_name = patient_name;
        this.breed = breed;
        this.owner_first_name = owner_first_name;
        this.owner_last_name = owner_last_name;
        this.owner_email = owner_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwner_first_name() {
        return owner_first_name;
    }

    public void setOwner_first_name(String owner_first_name) {
        this.owner_first_name = owner_first_name;
    }

    public String getOwner_last_name() {
        return owner_last_name;
    }

    public void setOwner_last_name(String owner_last_name) {
        this.owner_last_name = owner_last_name;
    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String owner_email) {
        this.owner_email = owner_email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patient_name='" + patient_name + '\'' +
                ", breed='" + breed + '\'' +
                ", owner_first_name='" + owner_first_name + '\'' +
                ", owner_last_name='" + owner_last_name + '\'' +
                ", owner_email='" + owner_email + '\'' +
                '}';
    }
}
