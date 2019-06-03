package neurology.app.model;

public class DiagnosisModel {
	
	private String diagnosisName;
	private String nodeState;
	private float diagnosisPercentage;
	
	public DiagnosisModel() {
		
	}
	
	public DiagnosisModel(String diagnosisName, String nodeState, float diagnosisPercentage) {
		super();
		this.diagnosisName = diagnosisName;
		this.nodeState = nodeState;
		this.diagnosisPercentage = diagnosisPercentage;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getNodeState() {
		return nodeState;
	}

	public void setNodeState(String nodeState) {
		this.nodeState = nodeState;
	}

	public float getDiagnosisPercentage() {
		return diagnosisPercentage;
	}

	public void setDiagnosisPercentage(float diagnosisPercentage) {
		this.diagnosisPercentage = diagnosisPercentage;
	}
	
}
