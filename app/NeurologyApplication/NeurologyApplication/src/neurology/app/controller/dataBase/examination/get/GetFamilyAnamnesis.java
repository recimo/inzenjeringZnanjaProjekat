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
import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.local.AnamnesisFamily;

public class GetFamilyAnamnesis {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private AnamnesisFamily anamnesisFamily;

	public GetFamilyAnamnesis() {
		this.anamnesisFamily = new AnamnesisFamily();
	}

	public boolean getFamilyAnamnesis() {

		this.anamnesisFamily.getAnamnesisFamily().clear();
		String selectString = PREFIX
				+ "SELECT ?id ?cerebrovascular ?diabetes ?endocrine ?headache ?hypertension ?menatlIllness "
				+ "WHERE { " + "	?examination a na:FamilyAnamnesis;" + "    na:id ?id; "
				+ "   	na:cerebrovascular ?cerebrovascular; " + "	na:diabetes        ?diabetes; "
				+ "    na:endocrine       ?endocrine; " + "	na:headache        ?headache; "
				+ "    na:hypertension    ?hypertension; " + "	na:menatlIllness   ?menatlIllness . " + "}";
		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalCere = solution.getLiteral("cerebrovascular");
				Literal literalDiab = solution.getLiteral("diabetes");
				Literal literalEndo = solution.getLiteral("endocrine");
				Literal literalHead = solution.getLiteral("headache");
				Literal literalHyper = solution.getLiteral("hypertension");
				Literal literalMental = solution.getLiteral("menatlIllness");

				FamilyAnamnesis newFamilyAnamnesis = new FamilyAnamnesis();
				newFamilyAnamnesis.setId(Integer.parseInt(literalId.getString()));

				if (literalCere.getString().equals("true")) {
					newFamilyAnamnesis.setCerebrovascularDiseases(true);
				} else {
					newFamilyAnamnesis.setCerebrovascularDiseases(false);
				}

				if (literalDiab.getString().equals("true")) {
					newFamilyAnamnesis.setDiabetes(true);
				} else {
					newFamilyAnamnesis.setDiabetes(false);
				}

				if (literalEndo.getString().equals("true")) {
					newFamilyAnamnesis.setEndocrineDiseases(true);
				} else {
					newFamilyAnamnesis.setEndocrineDiseases(false);
				}

				if (literalHead.getString().equals("true")) {
					newFamilyAnamnesis.setHeadache(true);
				} else {
					newFamilyAnamnesis.setHeadache(false);
				}

				if (literalHyper.getString().equals("true")) {
					newFamilyAnamnesis.setHypertension(true);
				} else {
					newFamilyAnamnesis.setHypertension(false);
				}

				if (literalMental.getString().equals("true")) {
					newFamilyAnamnesis.setMentalIllnesses(true);
				} else {
					newFamilyAnamnesis.setMentalIllnesses(false);
				}

				this.anamnesisFamily.getAnamnesisFamily().add(newFamilyAnamnesis);
			}
			Singleton.getInstance().setAnamnesisFamily(anamnesisFamily);
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA FAMILY");
			e.printStackTrace();
		}
		return false;
	}

}
