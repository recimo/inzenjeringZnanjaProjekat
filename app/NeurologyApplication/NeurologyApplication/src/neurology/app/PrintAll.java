package neurology.app;

import neurology.app.model.Examination;
import neurology.app.model.Symptom;
import neurology.app.model.local.Examinations;

public class PrintAll {

	private Examinations examinations;

	public PrintAll() {
		this.examinations = Singleton.getInstance().getExaminations();
	}

	public void action() {

		for (Examination examination : examinations.getExaminations()) {
			System.out.println("ID: " + examination.getId());
			System.out.println("	PACIJENT: " + examination.getPatient().getFirstName());
			System.out.println("	PERSONAL: " + examination.getPersonalAnamnesis().getId());
			System.out.println("	FAMILY: " + examination.getFamilyAnamnesis().getId());
			System.out.println("	SYMPTOMS: ");

			try {
				for (Symptom symptom : examination.getSymptoms()) {
					System.out.println("		SYMPTOM: " + symptom.getName());
				}
			} catch (Exception e) {
				
			}

			System.out.println("	DIAGNOSIS: " + examination.getFinalDiagnosisModel().getId());
			System.out.println("	MEDICATION: " + examination.getMedication());
			System.out.println("	PROCEDURE: " + examination.getProcedure());
		}

	}
}
