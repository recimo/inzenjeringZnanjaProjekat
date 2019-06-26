package neurology.app.model;

public class PhysicalExamination {

	private boolean musclesRecognition;
	private int visualAcuity;
	private int musclesStrength;
	private int pulse;
	private int lowerBloodPressure;
	private int upperBloodPressure;
	private boolean abnormalInvoluntaryMovements;
	private boolean seizures;
	private boolean problemsWithMovement;
	private boolean dizziness;
	private boolean focalWeakness;
	private boolean lossOfSensation;
	private boolean apraxia; // za sad, posle tulia test pomocu pravila iz prologa
	private boolean kneePain;
	private boolean hipPain;
	private boolean backPain;
	private boolean legPain;
	private boolean chestPain;

	public PhysicalExamination() {
		this.visualAcuity = 0;
		this.musclesStrength = 0;
		this.pulse = 0;
		this.lowerBloodPressure = 0;
		this.upperBloodPressure = 0;
	}

	public boolean isMusclesRecognition() {
		return musclesRecognition;
	}

	public void setMusclesRecognition(boolean musclesRecognition) {
		this.musclesRecognition = musclesRecognition;
	}

	public int getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(int visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public int getMusclesStrength() {
		return musclesStrength;
	}

	public void setMusclesStrength(int musclesStrength) {
		this.musclesStrength = musclesStrength;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public int getLowerBloodPressure() {
		return lowerBloodPressure;
	}

	public void setLowerBloodPressure(int lowerBloodPressure) {
		this.lowerBloodPressure = lowerBloodPressure;
	}

	public int getUpperBloodPressure() {
		return upperBloodPressure;
	}

	public void setUpperBloodPressure(int upperBloodPressure) {
		this.upperBloodPressure = upperBloodPressure;
	}

	public boolean isAbnormalInvoluntaryMovements() {
		return abnormalInvoluntaryMovements;
	}

	public void setAbnormalInvoluntaryMovements(boolean abnormalInvoluntaryMovements) {
		this.abnormalInvoluntaryMovements = abnormalInvoluntaryMovements;
	}

	public boolean isSeizures() {
		return seizures;
	}

	public void setSeizures(boolean seizures) {
		this.seizures = seizures;
	}

	public boolean isProblemsWithMovement() {
		return problemsWithMovement;
	}

	public void setProblemsWithMovement(boolean problemsWithMovement) {
		this.problemsWithMovement = problemsWithMovement;
	}

	public boolean isDizziness() {
		return dizziness;
	}

	public void setDizziness(boolean dizziness) {
		this.dizziness = dizziness;
	}

	public boolean isFocalWeakness() {
		return focalWeakness;
	}

	public void setFocalWeakness(boolean focalWeakness) {
		this.focalWeakness = focalWeakness;
	}

	public boolean isLossOfSensation() {
		return lossOfSensation;
	}

	public void setLossOfSensation(boolean lossOfSensation) {
		this.lossOfSensation = lossOfSensation;
	}

	public boolean isApraxia() {
		return apraxia;
	}

	public void setApraxia(boolean apraxia) {
		this.apraxia = apraxia;
	}

	public boolean isKneePain() {
		return kneePain;
	}

	public void setKneePain(boolean kneePain) {
		this.kneePain = kneePain;
	}

	public boolean isHipPain() {
		return hipPain;
	}

	public void setHipPain(boolean hipPain) {
		this.hipPain = hipPain;
	}

	public boolean isBackPain() {
		return backPain;
	}

	public void setBackPain(boolean backPain) {
		this.backPain = backPain;
	}

	public boolean isLegPain() {
		return legPain;
	}

	public void setLegPain(boolean legPain) {
		this.legPain = legPain;
	}

	public boolean isChestPain() {
		return chestPain;
	}

	public void setChestPain(boolean chestPain) {
		this.chestPain = chestPain;
	}

	@Override
	public String toString() {
		return "PhysicalExamination [musclesRecognition=" + musclesRecognition + ", visualAcuity=" + visualAcuity
				+ ", musclesStrength=" + musclesStrength + ", pulse=" + pulse + ", lowerBloodPressure="
				+ lowerBloodPressure + ", upperBloodPressure=" + upperBloodPressure + ", abnormalInvoluntaryMovements="
				+ abnormalInvoluntaryMovements + ", seizures=" + seizures + ", problemsWithMovement="
				+ problemsWithMovement + ", dizziness=" + dizziness + ", focalWeakness=" + focalWeakness
				+ ", lossOfSensation=" + lossOfSensation + ", apraxia=" + apraxia + ", kneePain=" + kneePain
				+ ", hipPain=" + hipPain + ", backPain=" + backPain + ", legPain=" + legPain + ", chestPain="
				+ chestPain + "]";
	}

}