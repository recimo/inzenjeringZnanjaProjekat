package neurology.app.controller.dataBase.examination.insert;

import java.util.ArrayList;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.Symptom;

public class InsertAdditionalExamination {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private String id;

	private ArrayList<Symptom> symptoms;

	public InsertAdditionalExamination(ArrayList<Symptom> symptoms, String id) {
		this.id = id;
		this.symptoms = symptoms;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "AdditionalExamination a na:AdditionalExamination; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		int i;
		for (i = 0; i < symptoms.size() - 1; ++i) {
			insertString += " na:" + symptoms.get(i).getName() + " \"" + symptoms.get(i).isChecked()
					+ "\"^^xsd:boolean; ";
		}

		insertString += " na:" + symptoms.get(i).getName() + " \"" + symptoms.get(i).isChecked()
				+ "\"^^xsd:boolean. } ";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}

}
