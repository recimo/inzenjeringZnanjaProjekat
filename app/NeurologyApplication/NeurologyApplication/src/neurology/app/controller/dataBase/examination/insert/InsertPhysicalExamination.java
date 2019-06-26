package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.PhysicalExamination;

public class InsertPhysicalExamination {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private String id;

	private PhysicalExamination physicalExamination;

	public InsertPhysicalExamination(PhysicalExamination physicalExamination, String id) {
		this.id = id;
		this.physicalExamination = physicalExamination;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "PhysicalExamination a na:PhysicalExamination; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		// physicalExamination
		insertString += " na:musclesRecognition " + "\"" + physicalExamination.isMusclesRecognition() + "\"^^xsd:boolean; ";
		insertString += " na:visualAcuity " + "\"" + physicalExamination.getVisualAcuity() + "\"^^xsd:string; ";
		insertString += " na:musclesStrength " + "\"" + physicalExamination.getMusclesStrength() + "\"^^xsd:string; ";
		insertString += " na:pulse " + "\"" + physicalExamination.getPulse() + "\"^^xsd:string; ";
		insertString += " na:lowerBloodPressure " + "\"" + physicalExamination.getLowerBloodPressure() + "\"^^xsd:string; ";
		insertString += " na:upperBloodPressure " + "\"" + physicalExamination.getUpperBloodPressure() + "\"^^xsd:string; ";
		insertString += " na:abnormalInvoluntaryMovements " + "\"" + physicalExamination.isAbnormalInvoluntaryMovements() + "\"^^xsd:boolean; ";
		insertString += " na:seizures " + "\"" + physicalExamination.isSeizures() + "\"^^xsd:boolean; ";
		insertString += " na:problemsWithMovement " + "\"" + physicalExamination.isProblemsWithMovement() + "\"^^xsd:boolean; ";
		insertString += " na:dizziness " + "\"" + physicalExamination.isDizziness() + "\"^^xsd:boolean; ";
		insertString += " na:focalWeakness " + "\"" + physicalExamination.isFocalWeakness() + "\"^^xsd:boolean; ";
		insertString += " na:lossOfSensation " + "\"" + physicalExamination.isLossOfSensation() + "\"^^xsd:boolean; ";
		insertString += " na:apraxia " + "\"" + physicalExamination.isApraxia() + "\"^^xsd:boolean; ";
		insertString += " na:kneePain " + "\"" + physicalExamination.isKneePain() + "\"^^xsd:boolean; ";
		insertString += " na:hipPain " + "\"" + physicalExamination.isHipPain() + "\"^^xsd:boolean; ";
		insertString += " na:backPain " + "\"" + physicalExamination.isBackPain() + "\"^^xsd:boolean; ";
		insertString += " na:legPain " + "\"" + physicalExamination.isLegPain() + "\"^^xsd:boolean; ";
		insertString += " na:chestPain " + "\"" + physicalExamination.isChestPain() + "\"^^xsd:boolean . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
