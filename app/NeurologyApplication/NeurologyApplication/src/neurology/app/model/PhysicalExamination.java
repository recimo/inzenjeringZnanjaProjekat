package neurology.app.model;

public class PhysicalExamination {

	private boolean musclesRecognition;
	private int visualAcuity;
	private int musclesStrength;
	private int pulse;
	private int lowerBloodPressure;
	private int upperBloodPressure;

	public PhysicalExamination() {

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

}