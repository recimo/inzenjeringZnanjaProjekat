package neurology.app;

import neurology.app.controller.dataBase.examination.get.GetDiagnosisModels;
import neurology.app.controller.dataBase.examination.get.GetExaminations;
import neurology.app.controller.dataBase.examination.get.GetFamilyAnamnesis;
import neurology.app.controller.dataBase.examination.get.GetPersonalAnamnesis;
import neurology.app.controller.dataBase.examination.get.GetPhysicalExaminations;
import neurology.app.controller.dataBase.examination.get.GetSymptoms;
import neurology.app.controller.dataBase.patient.GetPatients;

public class GetAll {

	public void action() {
		GetPatients getPatients = new GetPatients();
		if (getPatients.getPatients()) {
			System.out.println("Patients");
		}

		GetExaminations getExaminations = new GetExaminations();
		if (getExaminations.getExaminations()) {
			System.out.println("Examinations");
		}

		GetPersonalAnamnesis getPersonal = new GetPersonalAnamnesis();
		if (getPersonal.getPersonalAnamnesis()) {
			System.out.println("Personal Anamnesis");
		}

		GetFamilyAnamnesis getFamily = new GetFamilyAnamnesis();
		if (getFamily.getFamilyAnamnesis()) {
			System.out.println("Family");
		}

		GetSymptoms getSymptoms = new GetSymptoms();
		if (getSymptoms.getSymptoms()) {
			System.out.println("Symptoms");
		}

		GetPhysicalExaminations getPhysical = new GetPhysicalExaminations();
		if (getPhysical.getPhysicalExaminations()) {
			System.out.println("Physical");
		}

		GetDiagnosisModels getDiagnosis = new GetDiagnosisModels();
		if (getDiagnosis.getDiagnosisModels()) {
			System.out.println("Diagnosis");
		}
	}
}
