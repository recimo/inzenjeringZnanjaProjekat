package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.PhysicalExamination;

public class InsertPhysicalExamination {

	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private int id;

	private PhysicalExamination physicalExamination;

	public InsertPhysicalExamination(PhysicalExamination physicalExamination, int id) {
		this.id = id;
		this.physicalExamination = physicalExamination;
	}

	public void insert() {
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "PhysicalExamination a na:PhysicalExamination; ";

		// id
		insertString += " na:id " + "\"" + this.id + "\"^^xsd:string; ";

		// physicalExamination
		insertString += " na:musclesRecognition " + "\"" + physicalExamination.isMusclesRecognition() + "\"^^xsd:string; ";
		insertString += " na:visualAcuity " + "\"" + physicalExamination.getVisualAcuity() + "\"^^xsd:string; ";
		insertString += " na:musclesStrength " + "\"" + physicalExamination.getMusclesStrength() + "\"^^xsd:string; ";
		insertString += " na:pulse " + "\"" + physicalExamination.getPulse() + "\"^^xsd:string; ";
		insertString += " na:lowerBloodPressure " + "\"" + physicalExamination.getLowerBloodPressure() + "\"^^xsd:string; ";
		insertString += " na:upperBloodPressure " + "\"" + physicalExamination.getUpperBloodPressure() + "\"^^xsd:string; ";
		insertString += " na:abnormalInvoluntaryMovements " + "\"" + physicalExamination.isAbnormalInvoluntaryMovements() + "\"^^xsd:string; ";
		insertString += " na:seizures " + "\"" + physicalExamination.isSeizures() + "\"^^xsd:string; ";
		insertString += " na:problemsWithMovement " + "\"" + physicalExamination.isProblemsWithMovement() + "\"^^xsd:string; ";
		insertString += " na:dizziness " + "\"" + physicalExamination.isDizziness() + "\"^^xsd:string; ";
		insertString += " na:focalWeakness " + "\"" + physicalExamination.isFocalWeakness() + "\"^^xsd:string; ";
		insertString += " na:lossOfSensation " + "\"" + physicalExamination.isLossOfSensation() + "\"^^xsd:string; ";
		insertString += " na:apraxia " + "\"" + physicalExamination.isApraxia() + "\"^^xsd:string; ";
		insertString += " na:kneePain " + "\"" + physicalExamination.isKneePain() + "\"^^xsd:string; ";
		insertString += " na:hipPain " + "\"" + physicalExamination.isHipPain() + "\"^^xsd:string; ";
		insertString += " na:backPain " + "\"" + physicalExamination.isBackPain() + "\"^^xsd:string; ";
		insertString += " na:legPain " + "\"" + physicalExamination.isLegPain() + "\"^^xsd:string; ";
		insertString += " na:chestPain " + "\"" + physicalExamination.isChestPain() + "\"^^xsd:string . }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();
	}
}
