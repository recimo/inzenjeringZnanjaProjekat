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
import neurology.app.model.PhysicalExamination;
import neurology.app.model.local.PhysicalExaminations;

public class GetPhysicalExaminations {

	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private PhysicalExaminations physicalExaminations;

	public GetPhysicalExaminations() {
		this.physicalExaminations = new PhysicalExaminations();
	}

	public boolean getPhysicalExaminations() {

		this.physicalExaminations.getPhysicalExaminations().clear();
		String selectString = PREFIX + " SELECT " + "?id " + "?abnormalInvoluntaryMovements " + "?apraxia "
				+ "?backPain " + "?chestPain " + "?dizziness " + "?focalWeakness " + "?hipPain " + "?kneePain "
				+ "?legPain " + "?lossOfSensation " + "?lowerBloodPressure " + "?musclesRecognition "
				+ "?musclesStrength " + "?problemsWithMovement " + "?pulse " + "?seizures " + "?upperBloodPressure "
				+ "?visualAcuity " + "WHERE { " + "	?examination a na:PhysicalExamination ; "
				+ "    na:abnormalInvoluntaryMovements ?abnormalInvoluntaryMovements ; "
				+ "        na:apraxia                ?apraxia ; " + "        na:backPain              ?backPain ; "
				+ "        na:chestPain             ?chestPain ; " + "        na:dizziness             ?dizziness ; "
				+ "        na:focalWeakness        ?focalWeakness ; " + "        na:hipPain               ?hipPain ; "
				+ "        na:id                   ?id ; " + "        na:kneePain             ?kneePain ; "
				+ "        na:legPain             ?legPain ; " + "        na:lossOfSensation      ?lossOfSensation ; "
				+ "        na:lowerBloodPressure   ?lowerBloodPressure ; "
				+ "        na:musclesRecognition  ?musclesRecognition ; "
				+ "        na:musclesStrength     ?musclesStrength ; "
				+ "        na:problemsWithMovement  ?problemsWithMovement ; "
				+ "        na:pulse                ?pulse ; " + "        na:seizures               ?seizures ; "
				+ "        na:upperBloodPressure     ?upperBloodPressure ; "
				+ "        na:visualAcuity          ?visualAcuity . }";

		Query query = QueryFactory.create(selectString);
		try {
			QueryExecution qexec = QueryExecutionFactory.sparqlService(QUERY_URL, query);

			ResultSet results = qexec.execSelect();
			ResultSetRewindable resultSetRewindble = ResultSetFactory.copyResults(results);
			qexec.close();
			System.out.println("PHYSICAL SELECT: ");
			while (resultSetRewindble.hasNext()) {

				QuerySolution solution = resultSetRewindble.nextSolution();
				Literal literalId = solution.getLiteral("id");
				Literal literalAbnormal = solution.getLiteral("abnormalInvoluntaryMovements");
				Literal literalApraxia = solution.getLiteral("apraxia");
				Literal literalBpain = solution.getLiteral("backPain");
				Literal literalCpain = solution.getLiteral("chestPain");
				Literal literalDizziness = solution.getLiteral("dizziness");
				Literal literalFocal = solution.getLiteral("focalWeakness");
				Literal literalHip = solution.getLiteral("hipPain");
				Literal literalKnee = solution.getLiteral("kneePain");
				Literal literalLeg = solution.getLiteral("legPain");
				Literal literalLoss = solution.getLiteral("lossOfSensation");
				Literal literalLower = solution.getLiteral("lowerBloodPressure");
				Literal literalMrecognition = solution.getLiteral("musclesRecognition");
				Literal literalMstrength = solution.getLiteral("musclesStrength");
				Literal literalProblems = solution.getLiteral("problemsWithMovement");
				Literal literalPulse = solution.getLiteral("pulse");
				Literal literalSeizures = solution.getLiteral("seizures");
				Literal literalUpper = solution.getLiteral("upperBloodPressure");
				Literal literalVisual = solution.getLiteral("visualAcuity");

				PhysicalExamination newPhysicalExamination = new PhysicalExamination();
				newPhysicalExamination.setId(Integer.parseInt(literalId.getString()));

				if (literalAbnormal.getString().equals("true")) {
					newPhysicalExamination.setAbnormalInvoluntaryMovements(true);
				} else {
					newPhysicalExamination.setAbnormalInvoluntaryMovements(false);
				}

				if (literalApraxia.getString().equals("true")) {
					newPhysicalExamination.setApraxia(true);
				} else {
					newPhysicalExamination.setApraxia(false);
				}

				if (literalBpain.getString().equals("true")) {
					newPhysicalExamination.setBackPain(true);
				} else {
					newPhysicalExamination.setBackPain(false);
				}

				if (literalCpain.getString().equals("true")) {
					newPhysicalExamination.setChestPain(true);
				} else {
					newPhysicalExamination.setChestPain(false);
				}

				if (literalDizziness.getString().equals("true")) {
					newPhysicalExamination.setDizziness(true);
				} else {
					newPhysicalExamination.setDizziness(false);
				}

				if (literalFocal.getString().equals("true")) {
					newPhysicalExamination.setFocalWeakness(true);
				} else {
					newPhysicalExamination.setFocalWeakness(false);
				}

				if (literalHip.getString().equals("true")) {
					newPhysicalExamination.setHipPain(true);
				} else {
					newPhysicalExamination.setHipPain(false);
				}

				if (literalKnee.getString().equals("true")) {
					newPhysicalExamination.setKneePain(true);
				} else {
					newPhysicalExamination.setKneePain(false);
				}

				if (literalLeg.getString().equals("true")) {
					newPhysicalExamination.setLegPain(true);
				} else {
					newPhysicalExamination.setLegPain(false);
				}

				if (literalLoss.getString().equals("true")) {
					newPhysicalExamination.setLossOfSensation(true);
				} else {
					newPhysicalExamination.setLossOfSensation(false);
				}

				if (literalMrecognition.getString().equals("true")) {
					newPhysicalExamination.setMusclesRecognition(true);
				} else {
					newPhysicalExamination.setMusclesRecognition(false);
				}

				if (literalProblems.getString().equals("true")) {
					newPhysicalExamination.setProblemsWithMovement(true);
				} else {
					newPhysicalExamination.setProblemsWithMovement(false);
				}

				if (literalSeizures.getString().equals("true")) {
					newPhysicalExamination.setSeizures(true);
				} else {
					newPhysicalExamination.setSeizures(false);
				}

				newPhysicalExamination.setLowerBloodPressure(Integer.parseInt(literalLower.getString()));

				newPhysicalExamination.setMusclesStrength(Integer.parseInt(literalMstrength.getString()));

				newPhysicalExamination.setPulse(Integer.parseInt(literalPulse.getString()));

				newPhysicalExamination.setUpperBloodPressure(Integer.parseInt(literalUpper.getString()));

				newPhysicalExamination.setVisualAcuity(Integer.parseInt(literalVisual.getString()));

				this.physicalExaminations.getPhysicalExaminations().add(newPhysicalExamination);

			}

			Singleton.getInstance().setPhysicalExaminations(physicalExaminations);
			return true;

		} catch (Exception e) {
			System.out.println("GRESKA SELECT NAREDBA PHYSICAL");
			e.printStackTrace();
		}

		return false;
	}
}
