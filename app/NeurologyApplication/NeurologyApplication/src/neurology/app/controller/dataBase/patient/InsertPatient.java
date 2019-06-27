package neurology.app.controller.dataBase.patient;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFactory;
import org.apache.jena.query.ResultSetRewindable;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import neurology.app.Singleton;
import neurology.app.model.Patient;

public class InsertPatient {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String UPDATE_URL = "http://localhost:3030/inz/update";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";
	private Patient newPatient;

	public InsertPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

	public void insert() {
		if (checkId(newPatient.getIdentificationNumber())) {
			String insertString = PREFIX + " INSERT DATA { ";

			insertString += " na:" + newPatient.getIdentificationNumber() + "patient a na:Patient; ";
			insertString += " na:id " + "\"" + newPatient.getIdentificationNumber() + "\"^^xsd:string; ";
			insertString += " na:firstName " + "\"" + newPatient.getFirstName() + "\"^^xsd:string; ";
			insertString += " na:lastName " + "\"" + newPatient.getLastName() + "\"^^xsd:string; ";
			insertString += " na:age " + "\"" + newPatient.getDateOfBirth() + "\"^^xsd:string; ";
			insertString += " na:rightHand " + "\"" + newPatient.isRightHanded() + "\"^^xsd:string; ";
			insertString += " na:gender " + "\"" + newPatient.getGenderOfPatient().toString() + "\"^^xsd:string  .}";
			UpdateRequest updateRequest = UpdateFactory.create(insertString);
			UpdateProcessor updateProcessor = UpdateExecutionFactory.createRemote(updateRequest, UPDATE_URL);
			updateProcessor.execute();

			String insertIntoID = PREFIX + " INSERT DATA { ";
			insertIntoID += " na:Id a na:Identification ;";
			insertIntoID += " na:id na:" + newPatient.getIdentificationNumber() + "patient . }";
			UpdateRequest updateId = UpdateFactory.create(insertIntoID);
			UpdateProcessor updateProcessorId = UpdateExecutionFactory.createRemote(updateId, UPDATE_URL);
			updateProcessorId.execute();

			Singleton.getInstance().getPatients().getPatients().add(newPatient);

		} else {
			System.out.println("PACIJENT SA TIM ID VEC POSTOJI!");
		}
	}

	public boolean checkId(String id) {
		String selectString = PREFIX + " SELECT ?identifikacija ?id " + "WHERE {  " + "		?ids a na:Identification; "
				+ "		  na:id ?identifikacija . " + "		?identifikacija a na:Patient;" + "		  na:id ?id . }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
			
			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literal = solution.getLiteral("id");
				System.out.println(literal.getString().toUpperCase());
				System.out.println(id.toUpperCase());
				if (literal.getString().toUpperCase().equals(id.toUpperCase())) {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA ZA CHECK ID!");
			e.printStackTrace();
		}

		return false;

	}
}
