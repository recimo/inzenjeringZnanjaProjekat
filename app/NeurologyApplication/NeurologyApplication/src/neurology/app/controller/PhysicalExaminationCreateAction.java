package neurology.app.controller;

import neurology.app.model.Examination;
import neurology.app.model.PhysicalExamination;
import neurology.app.model.Symptom;

public class PhysicalExaminationCreateAction {
	public void action(PhysicalExamination newPhysicalExamination, boolean musclesRecognition,
			boolean abnormalInvoluntaryMovements, boolean seizures, boolean problemsWithMovement, String visualAcuity,
			String musclesStrength, boolean disturbanceOfMemory, boolean dizziness, boolean focalWeakness,
			boolean kneePain, boolean hipPain, boolean backPain, boolean legPain, boolean chestPain,
			boolean lossOfSensation, boolean apraxia, Examination examination, int pulse, int lower, int upper) {

		newPhysicalExamination.setPulse(pulse);
		newPhysicalExamination.setLowerBloodPressure(lower);
		newPhysicalExamination.setUpperBloodPressure(upper);
		newPhysicalExamination.setMusclesRecognition(musclesRecognition);
		newPhysicalExamination.setBackPain(backPain);
		newPhysicalExamination.setKneePain(kneePain);
		newPhysicalExamination.setHipPain(hipPain);
		newPhysicalExamination.setLegPain(legPain);
		newPhysicalExamination.setChestPain(chestPain);
		newPhysicalExamination.setVisualAcuity(Integer.parseInt(visualAcuity));
		newPhysicalExamination.setMusclesStrength(Integer.parseInt(musclesStrength));

		newPhysicalExamination.setLossOfSensation(lossOfSensation);
		if (lossOfSensation) {
			examination.getSymptoms().add(new Symptom("loss_of_sensation"));
		}

		newPhysicalExamination.setApraxia(apraxia);
		if (apraxia) {
			examination.getSymptoms().add(new Symptom("apraxia"));
		}

		newPhysicalExamination.setAbnormalInvoluntaryMovements(abnormalInvoluntaryMovements);
		if (abnormalInvoluntaryMovements) {
			examination.getSymptoms().add(new Symptom("abnormal_involuntary_movements"));
		}

		newPhysicalExamination.setSeizures(seizures);
		if (seizures) {
			examination.getSymptoms().add(new Symptom("seizures"));
		}

		newPhysicalExamination.setProblemsWithMovement(problemsWithMovement);
		if (problemsWithMovement) {
			examination.getSymptoms().add(new Symptom("problems_with_movement"));
		}

		newPhysicalExamination.setDizziness(dizziness);
		if (dizziness) {
			examination.getSymptoms().add(new Symptom("dizziness"));
		}

		newPhysicalExamination.setFocalWeakness(focalWeakness);
		if (focalWeakness) {
			examination.getSymptoms().add(new Symptom("focal_weakness"));
		}

	}

}
