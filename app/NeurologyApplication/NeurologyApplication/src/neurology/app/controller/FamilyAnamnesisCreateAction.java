package neurology.app.controller;

import neurology.app.model.anamnesis.FamilyAnamnesis;

public class FamilyAnamnesisCreateAction {

	public void action(FamilyAnamnesis newAnamnesis, boolean diabetes, boolean endo, boolean hyper, boolean cerebro,
			boolean headache, boolean mental) {

		newAnamnesis.setDiabetes(diabetes);
		newAnamnesis.setEndocrineDiseases(endo);
		newAnamnesis.setHypertension(hyper);
		newAnamnesis.setCerebrovascularDiseases(cerebro);
		newAnamnesis.setHeadache(headache);
		newAnamnesis.setMentalIllnesses(mental);
		

	}

}
