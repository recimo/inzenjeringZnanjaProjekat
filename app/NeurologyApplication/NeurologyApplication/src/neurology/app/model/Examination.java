package neurology.app.model;

import java.util.ArrayList;

import neurology.app.model.anamnesis.Anamnesis;

public class Examination {
	
	private Patient patient;
	private Anamnesis anamnesis;
	private PhysicalExamination physicalExamination;
	private AdditionalExamination additionalExamination;
	private ArrayList<Symptom> symptoms = new ArrayList<>();
	
	public Examination() {}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Anamnesis getAnamnesis() {
		return anamnesis;
	}

	public void setAnamnesis(Anamnesis anamnesis) {
		this.anamnesis = anamnesis;
	}

	public PhysicalExamination getPhysicalExamination() {
		return physicalExamination;
	}

	public void setPhysicalExamination(PhysicalExamination physicalExamination) {
		this.physicalExamination = physicalExamination;
	}

	public AdditionalExamination getAdditionalExamination() {
		return additionalExamination;
	}

	public void setAdditionalExamination(AdditionalExamination additionalExamination) {
		this.additionalExamination = additionalExamination;
	}

	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(ArrayList<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	

}
