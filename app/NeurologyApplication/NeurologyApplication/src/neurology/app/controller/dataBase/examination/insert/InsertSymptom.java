package neurology.app.controller.dataBase.examination.insert;

import java.util.ArrayList;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.Symptom;

public class InsertSymptom {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private int id;

	private Symptom symptom;

	public InsertSymptom(Symptom symptom, int id) {
		this.id = id;
		this.symptom = symptom;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id+this.symptom.getName() + " a na:Symptom; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		insertString += " na:symptomName " + "\"" + this.symptom.getName() + "\"^^xsd:string; ";
		insertString += " na:symptomValue " + "\"" + this.symptom.isChecked() + "\"^^xsd:string . } ";
		
		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}

}
