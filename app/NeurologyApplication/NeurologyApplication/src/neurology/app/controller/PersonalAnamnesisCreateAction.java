package neurology.app.controller;

import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;
import neurology.app.model.Examination;
import neurology.app.model.Symptom;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class PersonalAnamnesisCreateAction {
	public void action(PersonalAnamnesis newPersonalAnamnesis, boolean lackOfEnergyAndInterest, 
			boolean disturbanceOfMemory, String headache, String sight, boolean hearingLoss,
			boolean balanceLoss, boolean limbsPain, Examination examination) {
		newPersonalAnamnesis.setLackOfEnergyAndInterest(lackOfEnergyAndInterest);
		newPersonalAnamnesis.setDisturbanceOfMemory(disturbanceOfMemory);
		if(disturbanceOfMemory) {
			examination.getSymptoms().add(new Symptom("disturbance_of_memory"));
		}
		newPersonalAnamnesis.setHearingLoss(hearingLoss);
		newPersonalAnamnesis.setBalanceLoss(balanceLoss);
		newPersonalAnamnesis.setLimbsPain(limbsPain);

		boolean hasHeadache = true;
		if (headache.equals(HeadacheType.NoHeadche.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.NoHeadche);
			hasHeadache = false;
		} else if(headache.equals(HeadacheType.Pressure.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Pressure);
		} else if(headache.equals(HeadacheType.Pulsating.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Pulsating);
		} else if(headache.equals(HeadacheType.Tearing.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Tearing);
		} else {
			newPersonalAnamnesis.setHeadache(HeadacheType.Flank);
		}
		
		if(hasHeadache) {
			examination.getSymptoms().add(new Symptom("headache"));
		}
		
		if (sight.equals(ChangeOfSight.Blur.toString())) {
			newPersonalAnamnesis.setSight(ChangeOfSight.Blur);
		} else if(sight.equals(ChangeOfSight.DoubleVision.toString())) {
			newPersonalAnamnesis.setSight(ChangeOfSight.DoubleVision);
		} else if(sight.equals(ChangeOfSight.LoosingSightFull.toString())) {
			newPersonalAnamnesis.setSight(ChangeOfSight.LoosingSightFull);
		} else {
			newPersonalAnamnesis.setSight(ChangeOfSight.LoosingSightHalf);
		}

	}
}
