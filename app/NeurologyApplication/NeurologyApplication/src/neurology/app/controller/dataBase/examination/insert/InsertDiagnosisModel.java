package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.DiagnosisModel;

public class InsertDiagnosisModel {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private int id;

	private DiagnosisModel diagnosisModel;

	public InsertDiagnosisModel(DiagnosisModel diagnosisModel, int id) {
		this.id = id;
		this.diagnosisModel = diagnosisModel;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "DiagnosisModel a na:DiagnosisModel; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		insertString += " na:diagnosisName" + " \"" + diagnosisModel.getDiagnosisName() + "\"^^xsd:string; ";
		insertString += " na:diagnosisPercentage" + " \"" + diagnosisModel.getDiagnosisPercentage()+ "\"^^xsd:string . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
