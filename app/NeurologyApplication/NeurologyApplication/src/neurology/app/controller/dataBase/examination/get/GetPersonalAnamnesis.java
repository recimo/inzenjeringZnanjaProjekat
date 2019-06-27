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
import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;
import neurology.app.model.anamnesis.PersonalAnamnesis;
import neurology.app.model.local.AnamnesisPersonal;

public class GetPersonalAnamnesis {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private AnamnesisPersonal anamnesisPersonal;

	public GetPersonalAnamnesis() {
		this.anamnesisPersonal = new AnamnesisPersonal();
	}

	public boolean getPersonalAnamnesis() {

		this.anamnesisPersonal.getPersonalAnamnesis().clear();
		String selectString = PREFIX
				+ "SELECT ?id ?balanceLoss ?disturbanceOfMemory ?headacheType ?hearingLoss ?lackOfEnergyAndInterest ?limbsPain ?sight "
				+ "WHERE { " + "	?examination a na:PersonalAnamnesis; " + "    na:id ?id; "
				+ "   	na:balanceLoss               ?balanceLoss; "
				+ "	na:disturbanceOfMemory       ?disturbanceOfMemory; "
				+ "    na:headacheType              ?headacheType; " + "	na:hearingLoss               ?hearingLoss; "
				+ "    na:lackOfEnergyAndInterest   ?lackOfEnergyAndInterest; "
				+ "	na:limbsPain                 ?limbsPain; " + "    na:sight                     ?sight . " + "}";

		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);

			qexec.close();
			while (resultSetRewindble.hasNext()) {
				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalBalanceLoss = solution.getLiteral("balanceLoss");
				Literal literalDisturbanceOfMemory = solution.getLiteral("disturbanceOfMemory");
				Literal literalHeadacheType = solution.getLiteral("headacheType");
				Literal literalHearingLoss = solution.getLiteral("hearingLoss");
				Literal literalLackOfEnergyAndInterest = solution.getLiteral("lackOfEnergyAndInterest");
				Literal literalLimbsPain = solution.getLiteral("limbsPain");
				Literal literalSight = solution.getLiteral("sight");

				PersonalAnamnesis newPersonalAnamnesis = new PersonalAnamnesis();

				newPersonalAnamnesis.setId(literalId.getString());

				if (literalBalanceLoss.getString().equals("true")) {
					newPersonalAnamnesis.setBalanceLoss(true);
				} else {
					newPersonalAnamnesis.setBalanceLoss(false);
				}

				if (literalDisturbanceOfMemory.getString().equals("true")) {
					newPersonalAnamnesis.setDisturbanceOfMemory(true);
				} else {
					newPersonalAnamnesis.setDisturbanceOfMemory(false);
				}

				if (literalHeadacheType.getString().equals(HeadacheType.NoHeadche.toString())) {
					newPersonalAnamnesis.setHeadache(HeadacheType.NoHeadche);
					newPersonalAnamnesis.setHasHeadache(false);
				} else if (literalHeadacheType.getString().equals(HeadacheType.Pressure.toString())) {
					newPersonalAnamnesis.setHeadache(HeadacheType.Pressure);
					newPersonalAnamnesis.setHasHeadache(true);
				} else if (literalHeadacheType.getString().equals(HeadacheType.Pulsating.toString())) {
					newPersonalAnamnesis.setHeadache(HeadacheType.Pulsating);

				} else if (literalHeadacheType.getString().equals(HeadacheType.Tearing.toString())) {
					newPersonalAnamnesis.setHeadache(HeadacheType.Tearing);
					newPersonalAnamnesis.setHasHeadache(true);
				} else {
					newPersonalAnamnesis.setHeadache(HeadacheType.Flank);
					newPersonalAnamnesis.setHasHeadache(true);
				}

				if (literalHearingLoss.getString().equals("true")) {
					newPersonalAnamnesis.setHearingLoss(true);
				} else {
					newPersonalAnamnesis.setHearingLoss(false);
				}

				if (literalLackOfEnergyAndInterest.getString().equals("true")) {
					newPersonalAnamnesis.setLackOfEnergyAndInterest(true);
				} else {
					newPersonalAnamnesis.setLackOfEnergyAndInterest(false);
				}

				if (literalLimbsPain.getString().equals("true")) {
					newPersonalAnamnesis.setLimbsPain(true);
				} else {
					newPersonalAnamnesis.setLimbsPain(false);
				}

				if (literalSight.getString().equals(ChangeOfSight.Blur.toString())) {
					newPersonalAnamnesis.setSight(ChangeOfSight.Blur);
				} else if (literalSight.getString().equals(ChangeOfSight.DoubleVision.toString())) {
					newPersonalAnamnesis.setSight(ChangeOfSight.DoubleVision);
				} else if (literalSight.getString().equals(ChangeOfSight.LoosingSightFull.toString())) {
					newPersonalAnamnesis.setSight(ChangeOfSight.LoosingSightFull);
				} else {
					newPersonalAnamnesis.setSight(ChangeOfSight.LoosingSightHalf);
				}

				this.anamnesisPersonal.getPersonalAnamnesis().add(newPersonalAnamnesis);
			}
			Singleton.getInstance().setAnamnesisPersonal(anamnesisPersonal);
			return true;
		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA PERSONAL");
			e.printStackTrace();
		}
		return false;
	}
}
