package com.mvc.service;

import java.util.List;
import com.mvc.models.Patient;

public interface PatientService {
	void addPatient(Patient p);

	List<Patient> findAllPatient();

	Patient getPatientById(int id);

	void updatePatient(int id,Patient p);

	void deletePatientById(int id);

}
