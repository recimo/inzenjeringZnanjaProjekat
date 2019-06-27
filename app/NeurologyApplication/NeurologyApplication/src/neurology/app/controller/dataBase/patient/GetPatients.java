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

import neurology.app.Singleton;
import neurology.app.enumerations.Gender;
import neurology.app.model.Patient;
import neurology.app.model.local.Patients;

public class GetPatients {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private Patients patients;

	public GetPatients() {
		this.patients = new Patients();
	}

	public boolean getPatients() {

		this.patients.getPatients().clear();

		String selectString = PREFIX + " SELECT ?id ?ime ?prezime ?godine ?pol ?desnoruk " + "WHERE {"
				+ "	?pacijent a na:Patient;" + "           na:id ?id; " + "           na:firstName ?ime; "
				+ "           na:lastName ?prezime; " + "           na:age  ?godine; " + "           na:gender ?pol; "
				+ "           na:rightHand  ?desnoruk " + ". }";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();

			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalIme = solution.getLiteral("ime");
				Literal literalPrezime = solution.getLiteral("prezime");
				Literal literalGodine = solution.getLiteral("godine");
				Literal literalPol = solution.getLiteral("pol");
				Literal literalDesnoruk = solution.getLiteral("desnoruk");

				Patient newPatient = new Patient();
				newPatient.setIdentificationNumber(literalId.getString());
				newPatient.setFirstName(literalIme.getString());
				newPatient.setLastName(literalPrezime.getString());
				newPatient.setDateOfBirth(literalGodine.getString());
				if (literalPol.getString().equals("Male")) {
					newPatient.setGenderOfPatient(Gender.Male);
				} else {
					newPatient.setGenderOfPatient(Gender.Female);
				}

				if (literalDesnoruk.getString().equals("true")) {
					newPatient.setRightHanded(true);
				} else {
					newPatient.setRightHanded(false);
				}

				this.patients.getPatients().add(newPatient);

			}

			Singleton.getInstance().setPatients(this.patients);
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA ZA GET!");
			e.printStackTrace();
		}

		return false;
	}
}
