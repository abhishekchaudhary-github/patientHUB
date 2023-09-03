package com.project.project.service;

import com.project.project.entity.Patient;
import com.project.project.repository.PatientRepository;
import com.project.project.service.PatientService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;
    @Test
    public void testCreatePatient() {
        // Create a sample patient
        Patient samplePatient = new Patient();
        samplePatient.setId(1);
        samplePatient.setName("John");
        samplePatient.setDob(LocalDate.of(1985, 5, 15));
        samplePatient.setAddress("xyz");
        when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(samplePatient);
        Patient savedPatient = patientService.createPatient(samplePatient);
        Assertions.assertThat(savedPatient).isNotNull();
    }

    @Test
    public void testGetAllPatients() {
        // Create a list of sample patients
        List<Patient> samplePatients = new ArrayList<>();
        Patient samplePatient = new Patient();
        samplePatient.setId(1);
        samplePatient.setName("John");
        samplePatient.setDob(LocalDate.of(1985, 5, 15));
        samplePatient.setAddress("xyz");
        Patient samplePatient2 = new Patient();
        samplePatient2.setId(1);
        samplePatient2.setName("John");
        samplePatient2.setDob(LocalDate.of(1985, 5, 15));
        samplePatient2.setAddress("xyz");

        samplePatients.add(samplePatient);
        samplePatients.add(samplePatient2);

        when(patientRepository.findAll()).thenReturn(samplePatients);

        List<Patient> patients = patientService.getAllPatients();

        org.junit.jupiter.api.Assertions.assertNotNull(patients);
        org.junit.jupiter.api.Assertions.assertEquals(2, patients.size());


    }

    }