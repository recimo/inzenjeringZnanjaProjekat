package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.anamnesis.FamilyAnamnesis;

public class InsertFamilyAnamnesis {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private String id;

	private FamilyAnamnesis familyAnamnesis;

	public InsertFamilyAnamnesis(FamilyAnamnesis familyAnamnesis, String id) {
		this.id = id;
		this.familyAnamnesis = familyAnamnesis;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "FamilyAnamnesis a na:FamilyAnamnesis; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		// familyAnamnesis
		insertString += " na:diabetes " + "\"" + familyAnamnesis.isDiabetes() + "\"^^xsd:boolean; ";
		insertString += " na:endocrine " + "\"" + familyAnamnesis.isEndocrineDiseases() + "\"^^xsd:boolean; ";
		insertString += " na:hypertension " + "\"" + familyAnamnesis.isHypertension() + "\"^^xsd:boolean; ";
		insertString += " na:cerebrovascular " + "\"" + familyAnamnesis.isCerebrovascularDiseases() + "\"^^xsd:boolean; ";
		insertString += " na:headache " + "\"" + familyAnamnesis.isHeadache() + "\"^^xsd:boolean; ";
		insertString += " na:menatlIllness " + "\"" + familyAnamnesis.isMentalIllnesses() + "\"^^xsd:boolean . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
