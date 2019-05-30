package neurology.app.model.anamnesis;

public class FamilyAnamnesis {

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

}