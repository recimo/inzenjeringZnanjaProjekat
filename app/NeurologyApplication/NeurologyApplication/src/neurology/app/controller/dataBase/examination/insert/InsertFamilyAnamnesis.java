package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.anamnesis.FamilyAnamnesis;

public class InsertFamilyAnamnesis {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private int id;

	private FamilyAnamnesis familyAnamnesis;

	public InsertFamilyAnamnesis(FamilyAnamnesis familyAnamnesis, int id) {
		this.id = id;
		this.familyAnamnesis = familyAnamnesis;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "FamilyAnamnesis a na:FamilyAnamnesis; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		// familyAnamnesis
		insertString += " na:diabetes " + "\"" + familyAnamnesis.isDiabetes() + "\"^^xsd:string; ";
		insertString += " na:endocrine " + "\"" + familyAnamnesis.isEndocrineDiseases() + "\"^^xsd:string; ";
		insertString += " na:hypertension " + "\"" + familyAnamnesis.isHypertension() + "\"^^xsd:string; ";
		insertString += " na:cerebrovascular " + "\"" + familyAnamnesis.isCerebrovascularDiseases() + "\"^^xsd:string; ";
		insertString += " na:headache " + "\"" + familyAnamnesis.isHeadache() + "\"^^xsd:string; ";
		insertString += " na:menatlIllness " + "\"" + familyAnamnesis.isMentalIllnesses() + "\"^^xsd:string . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
