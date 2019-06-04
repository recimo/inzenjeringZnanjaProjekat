package neurology.app.model;

public class DiagnosisModel implements Comparable<DiagnosisModel>{

	private String diagnosisName;
	private float diagnosisPercentage;

	public DiagnosisModel() {
		diagnosisPercentage = 0;
	}

	public DiagnosisModel(String diagnosisName, float diagnosisPercentage) {
		super();
		this.diagnosisName = diagnosisName;
		this.diagnosisPercentage = diagnosisPercentage;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public float getDiagnosisPercentage() {
		return diagnosisPercentage;
	}

	public void setDiagnosisPercentage(float diagnosisPercentage) {
		this.diagnosisPercentage = diagnosisPercentage;
	}

	@Override
	public int compareTo(DiagnosisModel o) {
		
		int compare = Float.compare(o.diagnosisPercentage, diagnosisPercentage);
		
		return compare;
	}

}
