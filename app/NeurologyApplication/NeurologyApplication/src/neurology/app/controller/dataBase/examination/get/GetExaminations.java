package neurology.app.controller.dataBase.examination.get;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import neurology.app.Singleton;
import neurology.app.model.Examination;
import neurology.app.model.Patient;
import neurology.app.model.local.Examinations;

public class GetExaminations {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private Examinations examinations;

	public GetExaminations() {
		this.examinations = new Examinations();
	}

	public boolean getExaminations() {
		String selectString = PREFIX + " SELECT ?id ?medication ?patientId ?procedure " + "WHERE {"
				+ "	?examination a na:Examination; " + "    na:id ?id; " + "    na:medication ?medication; "
				+ "	   na:patientId ?patientId; " + "    na:procedure  ?procedure . } ";

		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			while (results.hasNext()) {
				QuerySolution solution = results.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalMedication = solution.getLiteral("medication");
				Literal literalPatientId = solution.getLiteral("patientId");
				Literal literalProcedure = solution.getLiteral("procedure");

				Examination newExamination = new Examination();
				newExamination.setId(literalId.getString());
				newExamination.setMedication(literalMedication.getString());

				for (Patient patient : Singleton.getInstance().getPatients().getPatients()) {
					if (patient.getIdentificationNumber().equals(literalPatientId.getString())) {
						newExamination.setPatient(patient);
					}
				}

				newExamination.setProcedure(literalProcedure.getString());

				this.examinations.getExaminations().add(newExamination);
			}

			Singleton.getInstance().setExaminations(examinations);
			return true;

		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA EXAMINATIONS");
			e.printStackTrace();
		}

		return false;
	}

}
