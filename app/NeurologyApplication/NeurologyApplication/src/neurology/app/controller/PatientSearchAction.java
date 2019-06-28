package neurology.app.controller;

import java.util.ArrayList;

import neurology.app.Singleton;
import neurology.app.model.Patient;

public class PatientSearchAction {
	
	private Patient patient;
	
	public void action(String id){
		ArrayList<Patient> patientList = new ArrayList<>();
		
		try {
			patientList = Singleton.getInstance().getPatients().getPatients();
			
			for(Patient p : patientList) {
				if(p.getIdentificationNumber().equals(id)) {
					this.patient = p;
				}
			}
		} catch(Exception e) {
			System.out.println("Patient list empty");
		}
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
