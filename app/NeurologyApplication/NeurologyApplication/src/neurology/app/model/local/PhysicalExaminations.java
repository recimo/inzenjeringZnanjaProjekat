package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.PhysicalExamination;

public class PhysicalExaminations {

	private ArrayList<PhysicalExamination> physicalExaminations;

	public PhysicalExaminations() {
		this.physicalExaminations = new ArrayList<PhysicalExamination>();
	}

	public ArrayList<PhysicalExamination> getPhysicalExaminations() {
		return physicalExaminations;
	}

	public void setPhysicalExaminations(ArrayList<PhysicalExamination> physicalExaminations) {
		this.physicalExaminations = physicalExaminations;
	}

}