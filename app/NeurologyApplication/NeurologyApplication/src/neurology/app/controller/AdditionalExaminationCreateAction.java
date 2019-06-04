package neurology.app.controller;

import java.util.ArrayList;

import neurology.app.model.AdditionalExamination;
import neurology.app.model.Symptom;

public class AdditionalExaminationCreateAction {

	public void action(ArrayList<Symptom> symptoms) {
		AdditionalExamination additionalExamination = new AdditionalExamination();
		additionalExamination.setSymptomsToCheck(symptoms);
	}
}
