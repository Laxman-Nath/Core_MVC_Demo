package com.mvc.views;

import java.util.List;
import java.util.Scanner;

import com.mvc.models.Patient;
import com.mvc.serviceImpl.PatientServiceImpl;

public class PatientMain {
	static PatientServiceImpl patientService = new PatientServiceImpl();
//	static List<Patient> patients = patientService.findAllPatient();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice :");
			System.out.println("/********************************************************");
			System.out.println("1.Add Patient");
			System.out.println("2.Get all patient");
			System.out.println("3.Get Patient by Id");
			System.out.println("4.Delete Patient by id");
			System.out.println("5.Update patient");
			System.out.println("6.Exit");
			System.out.println("********************************************************/");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPatient(sc);
				break;
			case 2:
				getAllPatient();
				break;
			case 3:
				getPatientById(sc);
				break;
			case 4:
				deletePatientById(sc);
				break;
			case 5:
				updatePatient(sc);
				break;
			default:
				if (choice != 6) {
					System.out.println("Invalid choice!");
				}

			}
		} while (choice != 6);
		
		System.out.println("Thank you for using our system.Have a good day!");

//		addPatient(sc);
//		getAllPatient();
//		deletePatientById(sc);
//		getPatientById(sc);
//		updatePatient(sc);
	}

	public static void addPatient(Scanner sc) {
		Patient p = new Patient();
//		System.out.println("Enter patient id");
//		p.setId(sc.nextInt());
		System.out.println("Enter patient name");
		p.setName(sc.next());
		System.out.println("Enter patient address");
		p.setAddress(sc.next());
		System.out.println("Enter patient mobile number");
		p.setPhoneNumber(sc.nextLong());
		patientService.addPatient(p);

	}

	public static void getAllPatient() {
		List<Patient> patients = patientService.findAllPatient();
		if (!patients.isEmpty()) {
			System.out.println("__________________________________________________");
			System.out.printf("| %4s  | %6s  | %13s | %4s |", "Id", "Name", "Address", "Phone Number");
			System.out.println();
			System.out.println("__________________________________________________");
			for (Patient p : patients) {
				System.out.printf("| %4d  | %6s  | %13s | %12d |", p.getId(), p.getName(), p.getAddress(),
						p.getPhoneNumber());
				System.out.println();
				System.out.println("__________________________________________________");
			}
		}
		else {
			System.out.println("Database is empty");
		}

	}

//
	public static void deletePatientById(Scanner sc) {
		System.out.println("Enter patient id");
		int id = sc.nextInt();
		patientService.deletePatientById(id);
	}

	public static void getPatientById(Scanner sc) {
		System.out.println("Enter patient id");
		int id = sc.nextInt();
		Patient p = patientService.getPatientById(id);
		if (p == null ) {
			System.out.println("Either database is empty or such id doesn't exist in database");
		}
		else {
			
			System.out.println("Id=" + p.getId());
			System.out.println("Name=" + p.getName());
			System.out.println("Address=" + p.getAddress());
			System.out.println("Mobile no=" + p.getPhoneNumber());
		}

	}

	public static void updatePatient(Scanner sc) {
		Patient p = new Patient();
		System.out.println("Enter patient id which is to be updated");
		int id = sc.nextInt();
		System.out.println("Enter  patient's new name");
		p.setName(sc.next());
		System.out.println("Enter  patient's new address");
		p.setAddress(sc.next());
		System.out.println("Enter patient's new mobile number");
		p.setPhoneNumber(sc.nextLong());
		patientService.updatePatient(id, p);
	}

}
