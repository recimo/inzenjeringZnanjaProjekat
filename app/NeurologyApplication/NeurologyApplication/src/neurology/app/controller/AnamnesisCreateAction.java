package neurology.app.controller;

import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class AnamnesisCreateAction {
	public void action(PersonalAnamnesis newPersonalAnamnesis, boolean vaccined, boolean febrileState, 
			boolean lackOfEnergyAndInterest, boolean disturbanceOfMemory, String headache,
			String sight, boolean hearingLoss, boolean balanceLoss, boolean vertigo, boolean limbsPain) {
		newPersonalAnamnesis.setVaccined(vaccined);
		newPersonalAnamnesis.setFebrileState(febrileState);
		newPersonalAnamnesis.setLackOfEnergyAndInterest(lackOfEnergyAndInterest);
		newPersonalAnamnesis.setDisturbanceOfMemory(disturbanceOfMemory);
		newPersonalAnamnesis.setHearingLoss(hearingLoss);
		newPersonalAnamnesis.setBalanceLoss(balanceLoss);
		newPersonalAnamnesis.setVertigo(vertigo);
		newPersonalAnamnesis.setLimbsPain(limbsPain);

		if (headache.equals(HeadacheType.NoHeadche.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.NoHeadche);
		} else if(headache.equals(HeadacheType.Pressure.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Pressure);
		} else if(headache.equals(HeadacheType.Pulsating.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Pulsating);
		} else if(headache.equals(HeadacheType.Tearing.toString())) {
			newPersonalAnamnesis.setHeadache(HeadacheType.Tearing);
		} else {
			newPersonalAnamnesis.setHeadache(HeadacheType.Flank);
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
