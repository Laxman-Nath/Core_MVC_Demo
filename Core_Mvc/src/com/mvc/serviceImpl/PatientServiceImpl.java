package com.mvc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.models.Patient;
import com.mvc.repositry.DataBaseConnection;
import com.mvc.repositry.PatientRepositry;
import com.mvc.service.PatientService;

public class PatientServiceImpl implements PatientService {
//	static List<Patient> patients = new ArrayList<>();
	static Connection conn = DataBaseConnection.getConnection();

	@Override
	public void addPatient(Patient p) {
		if (conn != null) {
			String sql = "Insert into patient(name,address,phoneNumber) values ('" + p.getName() + "','"
					+ p.getAddress() + "','" + p.getPhoneNumber() + "')";
			try {
				Statement stm = conn.createStatement();
				int affectedRows = stm.executeUpdate(sql);
				if (affectedRows > 0) {
					System.out.println("Successfully inserted");
				} else {
					System.out.println("Error inserting");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Connection error");
		}

	}

	@Override
	public List<Patient> findAllPatient() {
		List<Patient> patients = new ArrayList<>();
		if (conn != null) {

			String query = "Select * from patient";
			try {
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);

				while (rs.next()) {
					Patient p = new Patient();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAddress(rs.getString(3));
					p.setPhoneNumber(rs.getLong(4));
					patients.add(p);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Connection error");
		}
		return patients;
	}

//
	@Override
	public void deletePatientById(int id) {
		if (conn != null) {

			String query = "Delete from patient where id =" + id;
			try {
				Statement stm = conn.createStatement();
				int affectedRows = stm.executeUpdate(query);
				if (affectedRows > 0) {
					System.out.println("Successfully deleted");
				} else {
					System.out.println("Error deleting");
				}
			} catch (SQLException e) {

			}

		} else {
			System.out.println("Connectin error");
		}
	}

	@Override
	public Patient getPatientById(int id) {
		Patient p = null;
		if (conn != null) {

			String query = "Select * from patient where id =" + id;
			try {
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);

				while (rs.next()) {
					p = new Patient();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setAddress(rs.getString(3));
					p.setPhoneNumber(rs.getLong(4));

				}
			} catch (SQLException e) {

			}
		}

		else {
			System.out.println("Connection error");
		}
		return p;
	}

	@Override
	public void updatePatient(int id, Patient patient) {
		if (conn != null) {

			Patient p = this.getPatientById(id);
			if (p != null) {
				String query = "Update patient set name='" + patient.getName() + "' ,address= ' " + patient.getAddress()
						+ "',phoneNumber='" + patient.getPhoneNumber() + "' where id=" + id;
				try {
					Statement stm = conn.createStatement();
					int affectedRows = stm.executeUpdate(query);
					if (affectedRows > 0) {
						System.out.println("Successfully updated");
					} else {
						System.out.println("Error updating");
					}
				} catch (SQLException e) {

				}

			} else {
				System.out.println("Either database is empty or such id doesn't exist in database");
			}
		} else {
			System.out.println("Connectin error");
		}
	}

}
