package com.project.project.service;

import com.project.project.entity.Patient;
import com.project.project.exception.ResourceNotFoundException;
import com.project.project.helper.PatientHelper;
import com.project.project.repository.PatientRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;
    @Test
    public void testCreatePatient() {
        // Create a sample patient
        Patient samplePatient = PatientHelper.makePatient(1,"John",LocalDate.of(1985, 5, 15),"xyz");
        when(patientRepository.save(any(Patient.class))).thenReturn(samplePatient);
        Patient savedPatient = patientService.createPatient(samplePatient);
        Assertions.assertThat(savedPatient).isNotNull();
    }

    @Test
    public void testGetAllPatients() {
        // Create a list of sample patients
        List<Patient> samplePatients = new ArrayList<>();
        Patient samplePatient = PatientHelper.makePatient(1,"John",LocalDate.of(1985, 5, 15),"xyz");
        Patient samplePatient2 = PatientHelper.makePatient(1,"John",LocalDate.of(1988, 3, 12),"123");
        samplePatients.add(samplePatient);
        samplePatients.add(samplePatient2);
        when(patientRepository.findAll()).thenReturn(samplePatients);
        List<Patient> patients = patientService.getAllPatients();
        assertNotNull(patients);
        assertEquals(2, patients.size());
    }

    @Test
    public void testUpdatePatient() {
        Patient samplePatient = PatientHelper.makePatient(1,"John",LocalDate.of(1985, 5, 15),"xyz");
        when(patientRepository.findById(1)).thenReturn(Optional.of(samplePatient));
        when(patientRepository.save(any(Patient.class))).thenReturn(samplePatient);
        Patient updatedPatient = PatientHelper.makePatient(1,"Smart",LocalDate.of(1985, 5, 15),"xyz");
        Patient response = patientService.updatePatient(1,updatedPatient);
        assertNotNull(response);
        assertEquals(updatedPatient.getName(), "Smart");

    }

    @Test
    public void testDeletePatient() {
        Patient samplePatient = PatientHelper.makePatient(1,"John",LocalDate.of(1985, 5, 15),"xyz");
        when(patientRepository.findById(1)).thenReturn(Optional.ofNullable(samplePatient));
        doNothing().when(patientRepository).delete(samplePatient);
        assertAll(() -> patientService.deletePatient(1));
    }

    @Test
    public void testGetPatientById_NonExistingPatient() {
        when(patientRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> {
            patientService.getPatientById(1);
        });
    }



    }