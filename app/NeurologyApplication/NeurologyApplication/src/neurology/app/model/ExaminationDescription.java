package neurology.app.model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class ExaminationDescription implements CaseComponent {
	
	//patient data
	private String identificationNumber;
	private int dateOfBirth;
	
	//personal anamnesis
	private String disturbanceOfMemory;
	private String headache;

	//physical examination
	private String problemsWithMovement;
	private String abnormalInvoluntaryMovements;
	private String seizures;
	private String lossOfSensation;
	private String dizziness;
	private String focalWeakness;
	private String disturbanceOfSmellAndTaste;
	private int pulse;
	private int lowerBloodPressure;
	private int upperBloodPressure;	
	
	//diagnosis name
	private String diagonsisName;
	private String medicationName;
	private String procedureName;
	
	
	

	
	public String getIdentificationNumber() {
		return identificationNumber;
	}





	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}





	public int getDateOfBirth() {
		return dateOfBirth;
	}





	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}





	public String getDisturbanceOfMemory() {
		return disturbanceOfMemory;
	}





	public void setDisturbanceOfMemory(String disturbanceOfMemory) {
		this.disturbanceOfMemory = disturbanceOfMemory;
	}





	public String getHeadache() {
		return headache;
	}





	public void setHeadache(String headache) {
		this.headache = headache;
	}





	public String getProblemsWithMovement() {
		return problemsWithMovement;
	}





	public void setProblemsWithMovement(String problemsWithMovement) {
		this.problemsWithMovement = problemsWithMovement;
	}





	public String getAbnormalInvoluntaryMovements() {
		return abnormalInvoluntaryMovements;
	}





	public void setAbnormalInvoluntaryMovements(String abnormalInvoluntaryMovements) {
		this.abnormalInvoluntaryMovements = abnormalInvoluntaryMovements;
	}





	public String getSeizures() {
		return seizures;
	}





	public void setSeizures(String seizures) {
		this.seizures = seizures;
	}





	public String getLossOfSensation() {
		return lossOfSensation;
	}





	public void setLossOfSensation(String lossOfSensation) {
		this.lossOfSensation = lossOfSensation;
	}





	public String getDizziness() {
		return dizziness;
	}





	public void setDizziness(String dizziness) {
		this.dizziness = dizziness;
	}





	public String getFocalWeakness() {
		return focalWeakness;
	}





	public void setFocalWeakness(String focalWeakness) {
		this.focalWeakness = focalWeakness;
	}





	public String getDisturbanceOfSmellAndTaste() {
		return disturbanceOfSmellAndTaste;
	}





	public void setDisturbanceOfSmellAndTaste(String disturbanceOfSmellAndTaste) {
		this.disturbanceOfSmellAndTaste = disturbanceOfSmellAndTaste;
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





	public String getDiagonsisName() {
		return diagonsisName;
	}





	public void setDiagonsisName(String diagonsisName) {
		this.diagonsisName = diagonsisName;
	}





	public String getMedicationName() {
		return medicationName;
	}





	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}





	public String getProcedureName() {
		return procedureName;
	}





	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}





	@Override
	public Attribute getIdAttribute() {
		return null;
	}





	@Override
	public String toString() {
		return "ExaminationDescription [identificationNumber=" + identificationNumber + ", dateOfBirth=" + dateOfBirth
				+ ", disturbanceOfMemory=" + disturbanceOfMemory + ", headache=" + headache + ", problemsWithMovement="
				+ problemsWithMovement + ", abnormalInvoluntaryMovements=" + abnormalInvoluntaryMovements
				+ ", seizures=" + seizures + ", lossOfSensation=" + lossOfSensation + ", dizziness=" + dizziness
				+ ", focalWeakness=" + focalWeakness + ", disturbanceOfSmellAndTaste=" + disturbanceOfSmellAndTaste
				+ ", pulse=" + pulse + ", lowerBloodPressure=" + lowerBloodPressure + ", upperBloodPressure="
				+ upperBloodPressure + ", diagonsisName=" + diagonsisName + "]";
	}

}
