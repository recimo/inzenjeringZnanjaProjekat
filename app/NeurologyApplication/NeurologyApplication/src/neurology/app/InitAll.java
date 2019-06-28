package neurology.app;

import neurology.app.model.DiagnosisModel;
import neurology.app.model.Examination;
import neurology.app.model.PhysicalExamination;
import neurology.app.model.Symptom;
import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.anamnesis.PersonalAnamnesis;
import neurology.app.model.local.AnamnesisFamily;
import neurology.app.model.local.AnamnesisPersonal;
import neurology.app.model.local.DiagnosisModels;
import neurology.app.model.local.Examinations;
import neurology.app.model.local.PhysicalExaminations;
import neurology.app.model.local.Symptoms;

public class InitAll {

	private Examinations examinations;
	private AnamnesisPersonal personalAnamnesis;
	private AnamnesisFamily familyAnamnesis;
	private PhysicalExaminations physicalExaminations;
	private Symptoms symptoms;
	private DiagnosisModels diagnosisModels;

	public InitAll() {
		this.examinations = Singleton.getInstance().getExaminations();
		this.personalAnamnesis = Singleton.getInstance().getAnamnesisPersonal();
		this.familyAnamnesis = Singleton.getInstance().getAnamnesisFamily();
		this.physicalExaminations = Singleton.getInstance().getPhysicalExaminations();
		this.symptoms = Singleton.getInstance().getSymptoms();
		this.diagnosisModels = Singleton.getInstance().getDiagnosisModels();
	}

	public void action() {
		initPersonal();
		initFamily();
		initPhysical();
		initSymptoms();
		initDiagnosis();
	}

	public void initPersonal() {
		for (Examination examination : this.examinations.getExaminations()) {
			for (PersonalAnamnesis personal : this.personalAnamnesis.getPersonalAnamnesis()) {
				if (personal.getId() == examination.getId()) {
					examination.setPersonalAnamnesis(personal);
				}
			}
		}
	}

	public void initFamily() {
		for (Examination examination : this.examinations.getExaminations()) {
			for (FamilyAnamnesis family : this.familyAnamnesis.getAnamnesisFamily()) {
				if (family.getId() == examination.getId()) {
					examination.setFamilyAnamnesis(family);
				}
			}
		}
	}

	public void initPhysical() {
		for (Examination examination : this.examinations.getExaminations()) {
			for (PhysicalExamination physical : this.physicalExaminations.getPhysicalExaminations()) {
				if (physical.getId() == examination.getId()) {
					examination.setPhysicalExamination(physical);
				}
			}
		}
	}

	public void initSymptoms() {
		for (Examination examination : this.examinations.getExaminations()) {
			for (Symptom symptom : this.symptoms.getSympotms()) {
				if (symptom.getId() == examination.getId()) {
					examination.getSymptoms().add(symptom);
				}
			}
		}
	}

	public void initDiagnosis() {
		for (Examination examination : this.examinations.getExaminations()) {
			for (DiagnosisModel diagnosis : this.diagnosisModels.getDiagnosisModels()) {
				if (diagnosis.getId() == examination.getId()) {
					examination.setFinalDiagnosisModel(diagnosis);
				}
			}
		}
	}
}
