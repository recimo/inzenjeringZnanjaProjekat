package neurology.app.model.anamnesis;

public class FamilyAnamnesis {

	private String id;
	private boolean diabetes;
	private boolean endocrineDiseases;
	private boolean hypertension;
	private boolean cerebrovascularDiseases;
	private boolean headache;
	private boolean mentalIllnesses;

	public FamilyAnamnesis() {

	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isEndocrineDiseases() {
		return endocrineDiseases;
	}

	public void setEndocrineDiseases(boolean endocrineDiseases) {
		this.endocrineDiseases = endocrineDiseases;
	}

	public boolean isHypertension() {
		return hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean isCerebrovascularDiseases() {
		return cerebrovascularDiseases;
	}

	public void setCerebrovascularDiseases(boolean cerebrovascularDiseases) {
		this.cerebrovascularDiseases = cerebrovascularDiseases;
	}

	public boolean isHeadache() {
		return headache;
	}

	public void setHeadache(boolean headache) {
		this.headache = headache;
	}

	public boolean isMentalIllnesses() {
		return mentalIllnesses;
	}

	public void setMentalIllnesses(boolean mentalIllnesses) {
		this.mentalIllnesses = mentalIllnesses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String retVal = "";
		retVal += "************************************\n";
		retVal += "FAMILY ANAMNESIS:\n";
		retVal += "Diabetes: " + this.isDiabetes() + "\n";
		retVal += "Endokrine: " + this.isEndocrineDiseases() + "\n";
		retVal += "Hipertension: " + this.isHypertension() + "\n";
		retVal += "Headache: " + this.isHeadache() + "\n";
		retVal += "Cerebrovascular: " + this.isCerebrovascularDiseases() + "\n";
		retVal += "Mental illness: " + this.isMentalIllnesses() + "\n";
		retVal += "************************************\n";

		return retVal;
	}

}