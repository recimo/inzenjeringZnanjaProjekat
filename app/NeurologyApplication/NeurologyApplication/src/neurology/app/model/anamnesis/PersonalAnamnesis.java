package neurology.app.model.anamnesis;

import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;

public class PersonalAnamnesis {

	private boolean vaccined;
	private boolean febrileState; // temperature nepoznatog porekla
	private boolean lackOfEnergyAndInterest;
	private boolean disturbanceOfMemory;
	private HeadacheType headache;
	private ChangeOfSight sight;
	private boolean hearingLoss;
	private boolean balanceLoss;
	private boolean vertigo;
	private boolean limbsPain;

	public PersonalAnamnesis() {

	}

	public boolean isVaccined() {
		return vaccined;
	}

	public void setVaccined(boolean vaccined) {
		this.vaccined = vaccined;
	}

	public boolean isFebrileState() {
		return febrileState;
	}

	public void setFebrileState(boolean febrileState) {
		this.febrileState = febrileState;
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

	public boolean isVertigo() {
		return vertigo;
	}

	public void setVertigo(boolean vertigo) {
		this.vertigo = vertigo;
	}

	public boolean isLimbsPain() {
		return limbsPain;
	}

	public void setLimbsPain(boolean limbsPain) {
		this.limbsPain = limbsPain;
	}

}