package com.project.project.helper;
import com.project.project.entity.Patient;
import java.time.LocalDate;

public class PatientHelper {
    public static Patient makePatient(Integer id, String name, LocalDate dob, String address) {
        Patient patient = new Patient();
        patient.setId(id);
        patient.setName(name);
        patient.setDob(dob);
        patient.setAddress(address);
        return patient;
    }
}
