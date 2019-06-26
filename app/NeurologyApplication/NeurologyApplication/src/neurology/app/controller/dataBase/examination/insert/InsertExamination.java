package neurology.app.controller.dataBase.examination.insert;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.model.Examination;

public class InsertExamination {

	private Examination examination;
	private int id = 0;

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	public InsertExamination(Examination examination) {
		this.examination = examination;
	}

	public boolean setID() {
		String selectString = PREFIX + " SELECT ?identifikacija ?id " + "WHERE {  " + "		?ids a na:ExaminationId; "
				+ "		  na:id ?identifikacija . " + "		?identifikacija a na:Examination;"
				+ "		  na:id ?id . }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				Literal literal = solution.getLiteral("id");
				this.id = Integer.parseInt(literal.getString());
				this.id++;
				System.out.println(this.id);
			}
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA ZA CHECK ID!");
			e.printStackTrace();
		}

		return false;

	}

	public void insert() {

		setID();
		String insertString = PREFIX + " INSERT DATA { ";

		insertString += " na:" + this.id + "Examination a na:Examination; ";
		// id
		insertString += " na:id " + "\"" + this.id +"Examination " + "\"^^xsd:string; ";
		// patient
		insertString += " na:patientId " + "\"" + examination.getPatient().getIdentificationNumber()
				+ "\"^^xsd:string; ";

		// medication
		insertString += " na:medication " + "\"" + examination.getMedication() + "\"^^xsd:string; ";

		// procedure
		insertString += " na:procedure " + "\"" + examination.getProcedure() + "\"^^xsd:string .  }";

		UpdateRequest updateRequest = UpdateFactory.create(insertString);
		UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
		updateProcessor.execute();

		String insertIntoID = PREFIX + " INSERT DATA { ";
		insertIntoID += " na:IdExam a na:ExaminationId ;";
		insertIntoID += " na:id na:" + this.id + "examination . }";
		UpdateRequest updateId = UpdateFactory.create(insertIntoID);
		UpdateProcessor updateProcessorId = UpdateExecutionFactory.createRemote(updateId, UPDATE_URL);
		updateProcessorId.execute();

		// personalAnamnesis
		InsertPersonalAnamnesis insertPersonalAnamnesis = new InsertPersonalAnamnesis(
				examination.getPersonalAnamnesis(), this.id + "Examination");
		insertPersonalAnamnesis.insert();

		// familyAnamnesis
		InsertFamilyAnamnesis insertFamilyAnamnesis = new InsertFamilyAnamnesis(examination.getFamilyAnamnesis(),
				this.id + "Examination");
		insertFamilyAnamnesis.insert();

		// physicalExamination
		InsertPhysicalExamination insertPhysicalExamination = new InsertPhysicalExamination(
				examination.getPhysicalExamination(), this.id + "Examination");
		insertPhysicalExamination.insert();

		// additionalExamination
		InsertAdditionalExamination insertAdditionalExamination = new InsertAdditionalExamination(
				examination.getSymptoms(), this.id + "Examination");
		insertAdditionalExamination.insert();

		// diagnosis model
		InsertDiagnosisModel insertDiagnosisModel = new InsertDiagnosisModel(examination.getFinalDiagnosisModel(),
				this.id + "Examination");
		insertDiagnosisModel.insert();

	}

}
