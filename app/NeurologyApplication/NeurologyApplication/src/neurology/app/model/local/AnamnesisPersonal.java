package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.anamnesis.PersonalAnamnesis;

public class AnamnesisPersonal {

	private ArrayList<PersonalAnamnesis> personalAnamnesis;

	public AnamnesisPersonal() {
		this.personalAnamnesis = new ArrayList<PersonalAnamnesis>();
	}

	public ArrayList<PersonalAnamnesis> getPersonalAnamnesis() {
		return personalAnamnesis;
	}

	public void setPersonalAnamnesis(ArrayList<PersonalAnamnesis> personalAnamnesis) {
		this.personalAnamnesis = personalAnamnesis;
	}

}