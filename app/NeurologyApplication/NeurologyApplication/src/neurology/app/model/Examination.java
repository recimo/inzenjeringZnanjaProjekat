package neurology.app.model;

import java.util.ArrayList;

import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class Examination {
	
	private Patient patient;
	private PersonalAnamnesis personalAnamnesis;
	private FamilyAnamnesis familyAnamnesis;
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

	public PersonalAnamnesis getPersonalAnamnesis() {
		return personalAnamnesis;
	}

	public void setPersonalAnamnesis(PersonalAnamnesis personalAnamnesis) {
		this.personalAnamnesis = personalAnamnesis;
	}

	public FamilyAnamnesis getFamilyAnamnesis() {
		return familyAnamnesis;
	}

	public void setFamilyAnamnesis(FamilyAnamnesis familyAnamnesis) {
		this.familyAnamnesis = familyAnamnesis;
	}
	
	

}
