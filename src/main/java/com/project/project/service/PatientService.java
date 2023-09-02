package com.project.project.service;

import com.project.project.entity.Patient;
import com.project.project.exception.ResourceNotFoundException;
import com.project.project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Cacheable("patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Cacheable("patients")
    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("patient not found"));
    }

    @CacheEvict(value = "patients", allEntries = true)
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @CacheEvict(value = "patients", allEntries = true)
    public Patient updatePatient(Integer id, Patient updatedPatient) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        patient.setName(updatedPatient.getName());
        patient.setDob(updatedPatient.getDob());
        patient.setAddress(updatedPatient.getAddress());

        return patientRepository.save(patient);
    }

    @CacheEvict(value = "patients", allEntries = true)
    public void deletePatient(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        patientRepository.delete(patient);
    }
}
