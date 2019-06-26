package neurology.app.model.anamnesis;

import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;

public class PersonalAnamnesis {

	private String id;
	private boolean lackOfEnergyAndInterest;
	private boolean disturbanceOfMemory;
	private HeadacheType headache;
	private boolean hasHeadache;
	private ChangeOfSight sight;
	private boolean hearingLoss;
	private boolean balanceLoss;
	private boolean limbsPain;

	public PersonalAnamnesis() {

	}

	public boolean isLackOfEnergyAndInterest() {
		return lackOfEnergyAndInterest;
	}

	public void setLackOfEnergyAndInterest(boolean lackOfEnergyAndInterest) {
		this.lackOfEnergyAndInterest = lackOfEnergyAndInterest;
	}

	public boolean isDisturbanceOfMemory() {
		return disturbanceOfMemory;
	}

	public void setDisturbanceOfMemory(boolean disturbanceOfMemory) {
		this.disturbanceOfMemory = disturbanceOfMemory;
	}

	public HeadacheType getHeadache() {
		return headache;
	}

	public void setHeadache(HeadacheType headache) {
		this.headache = headache;
	}

	public ChangeOfSight getSight() {
		return sight;
	}

	public void setSight(ChangeOfSight sight) {
		this.sight = sight;
	}

	public boolean isHearingLoss() {
		return hearingLoss;
	}

	public void setHearingLoss(boolean hearingLoss) {
		this.hearingLoss = hearingLoss;
	}

	public boolean isBalanceLoss() {
		return balanceLoss;
	}

	public void setBalanceLoss(boolean balanceLoss) {
		this.balanceLoss = balanceLoss;
	}

	public boolean isLimbsPain() {
		return limbsPain;
	}

	public void setLimbsPain(boolean limbsPain) {
		this.limbsPain = limbsPain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isHasHeadache() {
		return hasHeadache;
	}

	public void setHasHeadache(boolean hasHeadache) {
		this.hasHeadache = hasHeadache;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal += "************************************\n";
		retVal += "PERSONAL ANAMNESIS:\n";
		retVal += "Lack Of Energy And Interest: " + this.isLackOfEnergyAndInterest() + "\n";
		retVal += "Disturbance of memory: " + this.isDisturbanceOfMemory() + "\n";
		retVal += "Headache Type: " + this.getHeadache() + "\n";
		retVal += "Sight: " + this.getSight() + "\n";
		retVal += "Hearing Loss: " + this.isHearingLoss() + "\n";
		retVal += "Balance Loss: " + this.isBalanceLoss() + "\n";
		retVal += "Limbs Pain: " + this.isLimbsPain() + "\n";
		retVal += "************************************\n";

		return retVal;
	}

}