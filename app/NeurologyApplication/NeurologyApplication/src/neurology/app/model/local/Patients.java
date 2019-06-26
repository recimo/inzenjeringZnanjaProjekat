package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.Patient;

public class Patients {

	private ArrayList<Patient> patients;

	public Patients() {
		this.patients = new ArrayList<Patient>();
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

}