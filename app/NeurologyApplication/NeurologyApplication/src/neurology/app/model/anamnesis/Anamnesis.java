package neurology.app.model.anamnesis;

import neurology.app.model.Patient;

public class Anamnesis {

	private Patient patient;
	private FamilyAnamnesis familyAnamnesis;
	private PersonalAnamnesis personalAnamnesis;

	public Anamnesis() {
		
		this.patient = new Patient();
		this.familyAnamnesis = new FamilyAnamnesis();
		this.personalAnamnesis = new PersonalAnamnesis();
		
		
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public FamilyAnamnesis getFamilyAnamnesis() {
		return familyAnamnesis;
	}

	public void setFamilyAnamnesis(FamilyAnamnesis familyAnamnesis) {
		this.familyAnamnesis = familyAnamnesis;
	}

	public PersonalAnamnesis getPersonalAnamnesis() {
		return personalAnamnesis;
	}

	public void setPersonalAnamnesis(PersonalAnamnesis personalAnamnesis) {
		this.personalAnamnesis = personalAnamnesis;
	}

}