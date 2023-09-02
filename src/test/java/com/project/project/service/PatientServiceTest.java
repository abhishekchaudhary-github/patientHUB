////package com.project.project.service;
////
////import com.project.project.entity.Patient;
////import com.project.project.repository.PatientRepository;
////import org.junit.jupiter.api.BeforeEach;
//import com.project.project.ProjectApplication;
//import com.project.project.entity.Patient;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////
////import java.time.LocalDate;
////
////@SpringBootTest
////class PatientServiceTest {
////    @Autowired
////    private PatientRepository patientRepository;
////
////    @Autowired
////    private PatientService service;
////
//////    @BeforeEach
//////    public void setUp() {
//////        Patient patient1 = new Patient();
//////        patient1.setId(1);
//////        patient1.setName( "John");
//////        patient1.setDob(LocalDate.of(1995, 5, 15));
//////        patient1.setAddress("xyz");
//////        patientRepository.save(patient1);
//////    }
////    @Test
////    public void testCreatePatient() {
////        // Create a new patient
////        Patient newPatient = new Patient();
////        newPatient.setId(2);
////        newPatient.setName( "John");
////        newPatient.setDob(LocalDate.of(1995, 5, 15));
////        newPatient.setAddress("xyz");
////        Patient createdPatient = service.createPatient(newPatient);
////
//////        // Verify that the created patient has an ID assigned
//////        assertNotNull(createdPatient.getId());
//////
//////        // Retrieve the created patient from the database
//////        Patient retrievedPatient = patientRepository.findById(createdPatient.getId()).orElse(null);
////
//////        // Verify that the retrieved patient matches the created patient
//////        assertNotNull(retrievedPatient);
//////        assertEquals(newPatient.getName(), retrievedPatient.getName());
//////        assertEquals(newPatient.getDob(), retrievedPatient.getDob());
//////        assertEquals(newPatient.getAddress(), retrievedPatient.getAddress());
////    }
////}
//
//
//import com.project.project.repository.PatientRepository;
//import com.project.project.service.PatientService;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//
//@SpringBootTest(classes = ProjectApplication.class)
//public class PatientServiceTest {
//    @InjectMocks
//    private PatientService patientService;
//
//    @Mock
//    private PatientRepository patientRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCreatePatient() {
//        // Create a sample patient
//        Patient samplePatient = new Patient();
//        samplePatient.setId(1);
//        samplePatient.setName("John Doe");
//        samplePatient.setDob(LocalDate.of(1985, 5, 15));
//        samplePatient.setAddress("123 Main St");
//
//        // Mock the repository's save method
//        Mockito.when(patientRepository.save(any(Patient.class))).thenReturn(samplePatient);
//
//        // Create a new patient using the service
//        Patient newPatient = new Patient();
//        newPatient.setName("Alice Johnson");
//        newPatient.setDob(LocalDate.of(1990, 8, 20));
//        newPatient.setAddress("456");
//
//        Patient responseEntity = patientService.createPatient(newPatient);
////
////        // Verify that the response is not null
//        Assertions.assertNotNull(responseEntity);
//
//        // Verify that the HTTP status code is 201 (Created)
// //       assertEquals(201, responseEntity.getStatusCodeValue());
//
//        // Verify that the created patient matches our sample patient
////        Patient createdPatient = responseEntity.getBody();
////        assertNotNull(createdPatient);
////        assertEquals(samplePatient.getId(), createdPatient.getId());
////        assertEquals(samplePatient.getName(), createdPatient.getName());
////        assertEquals(samplePatient.getDob(), createdPatient.getDob());
////        assertEquals(samplePatient.getAddress(), createdPatient.getAddress());
//    }
//
////    @Test
////    public void testGetPatientById_ExistingPatient() {
////        Patient patient = new Patient();
////        patient.setId(1);
////        patient.setName("John Doe");
////        patient.setDob(LocalDate.of(1990, 5, 15));
////        patient.setAddress("123 Main St");
////
////        // Mock the repository to return the patient
////        Mockito.when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
////
////        // Call the service method
////        Patient result = patientService.getPatientById(1);
////
////        // Assertions
////        assertNotNull(result);
////        assertEquals("John Doe", result.getName());
////    }
//}