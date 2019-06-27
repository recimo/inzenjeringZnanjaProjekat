package neurology.app.controller.dataBase.examination.get;

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
import neurology.app.model.Symptom;
import neurology.app.model.local.Symptoms;

public class GetSymptoms {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private Symptoms symptoms;

	public GetSymptoms() {
		this.symptoms = new Symptoms();
	}

	public boolean getSymptoms() {

		this.symptoms.getSympotms().clear();
		
		String selectString = PREFIX + " SELECT ?id ?symptomName ?symptomValue " + "WHERE { "
				+ "	?examination a na:Symptom; " + "    na:id ?id ; " + "	   na:symptomName ?symptomName; "
				+ "	   na:symptomValue ?symptomValue . }";

		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalName = solution.getLiteral("symptomName");
				Literal literalValue = solution.getLiteral("symptomValue");

				Symptom newSymptom = new Symptom();
				newSymptom.setId(literalId.getString());
				newSymptom.setName(literalName.getString());
				if (literalValue.getString().equals("true")) {
					newSymptom.setChecked(true);
				} else {
					newSymptom.setChecked(false);
				}

				this.symptoms.getSympotms().add(newSymptom);

			}
			Singleton.getInstance().setSymptoms(symptoms);
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA PERSONAL");
			e.printStackTrace();
		}
		return false;
	}
}