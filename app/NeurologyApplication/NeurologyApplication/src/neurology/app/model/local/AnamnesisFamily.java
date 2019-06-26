package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.anamnesis.FamilyAnamnesis;

public class AnamnesisFamily {

	private ArrayList<FamilyAnamnesis> anamnesisFamily;

	public AnamnesisFamily() {
		this.anamnesisFamily = new ArrayList<FamilyAnamnesis>();
	}

	public ArrayList<FamilyAnamnesis> getAnamnesisFamily() {
		return anamnesisFamily;
	}

	public void setAnamnesisFamily(ArrayList<FamilyAnamnesis> anamnesisFamily) {
		this.anamnesisFamily = anamnesisFamily;
	}

}