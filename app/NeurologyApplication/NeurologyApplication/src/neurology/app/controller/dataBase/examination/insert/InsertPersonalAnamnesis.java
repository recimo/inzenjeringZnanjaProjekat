package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.anamnesis.PersonalAnamnesis;

public class InsertPersonalAnamnesis {
	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private int id;

	private PersonalAnamnesis personalAnamnesis;

	public InsertPersonalAnamnesis(PersonalAnamnesis personalAnamnesis, int id) {
		this.id = id;
		this.personalAnamnesis = personalAnamnesis;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "PersonalAnamnesis a na:PersonalAnamnesis; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";
		//personalAnamnesis
		insertString += " na:lackOfEnergyAndInterest " + "\"" + personalAnamnesis.isLackOfEnergyAndInterest() + "\"^^xsd:string; ";
		insertString += " na:disturbanceOfMemory " + "\"" + personalAnamnesis.isDisturbanceOfMemory() + "\"^^xsd:string; ";
		insertString += " na:headacheType " + "\"" + personalAnamnesis.getHeadache().toString() + "\"^^xsd:string; ";
		insertString += " na:sight " + "\"" + personalAnamnesis.getSight().toString() + "\"^^xsd:string; ";
		insertString += " na:hearingLoss " + "\"" + personalAnamnesis.isHearingLoss() + "\"^^xsd:string; ";
		insertString += " na:balanceLoss " + "\"" + personalAnamnesis.isBalanceLoss() + "\"^^xsd:string; ";
		insertString += " na:limbsPain " + "\"" + personalAnamnesis.isLimbsPain() + "\"^^xsd:string . }";
	
		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
