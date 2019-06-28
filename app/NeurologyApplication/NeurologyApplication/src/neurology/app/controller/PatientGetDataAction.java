package neurology.app.controller;

import neurology.app.Singleton;
import neurology.app.model.Examination;
import neurology.app.model.Patient;
import neurology.app.model.local.AnamnesisFamily;
import neurology.app.model.local.AnamnesisPersonal;
import neurology.app.model.local.DiagnosisModels;
import neurology.app.model.local.Examinations;

public class PatientGetDataAction {

	private AnamnesisPersonal personalAnamnesis;
	private AnamnesisFamily familyAnamnesis;
	private DiagnosisModels diagnosisModels;
	private Patient patient;
	private boolean success;

	public PatientGetDataAction(Patient patient) {
		this.patient = patient;
		this.personalAnamnesis = new AnamnesisPersonal();
		this.familyAnamnesis = new AnamnesisFamily();
		this.diagnosisModels = new DiagnosisModels();
	}

	public void action() {

		Examinations examinations = new Examinations();

		try {
			examinations = Singleton.getInstance().getExaminations();

			for (Examination examination : examinations.getExaminations()) {
				if (examination.getPatient().equals(this.patient)) {
					this.personalAnamnesis.getPersonalAnamnesis().add(examination.getPersonalAnamnesis());
					this.familyAnamnesis.getAnamnesisFamily().add(examination.getFamilyAnamnesis());
					this.diagnosisModels.getDiagnosisModels().add(examination.getFinalDiagnosisModel());
					this.success = true;
				}
			}
		} catch (Exception e) {
			System.out.println("PUKO GETER!");
		}

	}

	public AnamnesisPersonal getPersonalAnamnesis() {
		return personalAnamnesis;
	}

	public void setPersonalAnamnesis(AnamnesisPersonal personalAnamnesis) {
		this.personalAnamnesis = personalAnamnesis;
	}

	public AnamnesisFamily getFamilyAnamnesis() {
		return familyAnamnesis;
	}

	public void setFamilyAnamnesis(AnamnesisFamily familyAnamnesis) {
		this.familyAnamnesis = familyAnamnesis;
	}

	public DiagnosisModels getDiagnosisModels() {
		return diagnosisModels;
	}

	public void setDiagnosisModels(DiagnosisModels diagnosisModels) {
		this.diagnosisModels = diagnosisModels;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}