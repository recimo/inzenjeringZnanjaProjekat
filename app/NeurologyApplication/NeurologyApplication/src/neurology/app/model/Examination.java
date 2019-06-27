package neurology.app.model;

import java.util.ArrayList;

import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class Examination {

	private int id;
	private Patient patient;
	private PersonalAnamnesis personalAnamnesis;
	private FamilyAnamnesis familyAnamnesis;
	private PhysicalExamination physicalExamination;
	private AdditionalExamination additionalExamination;
	private ArrayList<Symptom> symptoms = new ArrayList<>();
	private DiagnosisModel finalDiagnosisModel;
	private String medication;
	private String procedure;

	public Examination() {
	}

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

	public DiagnosisModel getFinalDiagnosisModel() {
		return finalDiagnosisModel;
	}

	public void setFinalDiagnosisModel(DiagnosisModel finalDiagnosisModel) {
		this.finalDiagnosisModel = finalDiagnosisModel;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}