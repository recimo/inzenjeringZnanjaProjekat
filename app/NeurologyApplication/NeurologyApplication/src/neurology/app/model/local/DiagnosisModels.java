package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.DiagnosisModel;

public class DiagnosisModels {

	private ArrayList<DiagnosisModel> diagnosisModels;

	public DiagnosisModels() {
		this.diagnosisModels = new ArrayList<DiagnosisModel>();
	}

	public ArrayList<DiagnosisModel> getDiagnosisModels() {
		return diagnosisModels;
	}

	public void setDiagnosisModels(ArrayList<DiagnosisModel> diagnosisModels) {
		this.diagnosisModels = diagnosisModels;
	}

}