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
import neurology.app.model.DiagnosisModel;
import neurology.app.model.local.DiagnosisModels;

public class GetDiagnosisModels {
	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private DiagnosisModels diagnosisModels;

	public GetDiagnosisModels() {
		this.diagnosisModels = new DiagnosisModels();
	}

	public boolean getDiagnosisModels() {

		this.diagnosisModels.getDiagnosisModels().clear();
		String selectString = PREFIX + "SELECT ?id ?diagnosisName ?diagnosisPercentage " + "WHERE { "
				+ "	?examination a na:DiagnosisModel;" + "    na:id ?id; " + "   	na:diagnosisName ?diagnosisName; "
				+ "	na:diagnosisPercentage ?diagnosisPercentage . " + "}";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);
			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalName = solution.getLiteral("diagnosisName");
				Literal literalPercentage = solution.getLiteral("diagnosisPercentage");

				DiagnosisModel newDiagnosisModel = new DiagnosisModel();
				newDiagnosisModel.setId(Integer.parseInt(literalId.getString()));
				newDiagnosisModel.setDiagnosisName(literalName.getString());
				Float percentage = Float.parseFloat(literalPercentage.getString());
				newDiagnosisModel.setDiagnosisPercentage(percentage);

				this.diagnosisModels.getDiagnosisModels().add(newDiagnosisModel);

			}

			Singleton.getInstance().setDiagnosisModels(diagnosisModels);
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA DIAGNOSIS");
			e.printStackTrace();

		}

		return false;
	}
}
