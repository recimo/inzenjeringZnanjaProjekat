package neurology.app.miscellaneous;

import java.util.Collection;

import neurology.app.enumerations.HeadacheType;
import neurology.app.model.Examination;
import neurology.app.model.ExaminationDescription;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class CBRFinder implements StandardCBRApplication {

	Connector _connector;
	/** Connector object */
	CBRCaseBase _caseBase;
	/** CaseBase object */

	NNConfig simConfig;
	
	public int flag = 0;

	/** KNN configuration */

	public void configure() throws ExecutionException {
		_connector = new CsvConnector();
		// _connector = new SparqlConnector(examinations);
		_caseBase = new LinealCaseBase(); // Create a Lineal case base for in-memory organization

		
		

	}

	public void setSimilarityConfigrationForDiagnosis() {
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average()); // global similarity function = average
		simConfig.addMapping(new Attribute("dateOfBirth", ExaminationDescription.class), new Interval(5));
		simConfig.addMapping(new Attribute("pulse", ExaminationDescription.class), new Interval(5));
		simConfig.addMapping(new Attribute("lowerBloodPressure", ExaminationDescription.class), new Interval(10));
		simConfig.addMapping(new Attribute("upperBloodPressure", ExaminationDescription.class), new Interval(10));

		simConfig.addMapping(new Attribute("problemsWithMovement", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("abnormalInvoluntaryMovements", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("seizures", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("lossOfSensation", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("dizziness", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("focalWeakness", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("disturbanceOfSmellAndTaste", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("disturbanceOfMemory", ExaminationDescription.class), new Equal());
		simConfig.addMapping(new Attribute("headache", ExaminationDescription.class), new Equal());

	}

	public void setSimilarityConfigrationForMedicationsAndProcedures() {
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average()); // global similarity function = average
		simConfig.addMapping(new Attribute("dateOfBirth", ExaminationDescription.class), new Interval(5));
		simConfig.addMapping(new Attribute("pulse", ExaminationDescription.class), new Interval(5));
		simConfig.addMapping(new Attribute("lowerBloodPressure", ExaminationDescription.class), new Interval(10));
		simConfig.addMapping(new Attribute("upperBloodPressure", ExaminationDescription.class), new Interval(10));

		simConfig.addMapping(new Attribute("diagonsisName", ExaminationDescription.class), new Equal());

	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");

		for (RetrievalResult nse : eval) {
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
			if (nse.get_case().getDescription().getClass() == ExaminationDescription.class) {
				ExaminationDescription ed = (ExaminationDescription) nse.get_case().getDescription();
				
				if (!CbrResult.potentialDiagnosis.containsKey(ed.getDiagonsisName()) && flag == 0) {
					CbrResult.potentialDiagnosis.put(ed.getDiagonsisName(), nse.getEval());
				}
				
				if (!CbrResult.potentialMedications.containsKey(ed.getMedicationName()) && flag == 1) {
					CbrResult.potentialMedications.put(ed.getMedicationName(), nse.getEval());
				}
				
				if (!CbrResult.potentialProcedures.containsKey(ed.getProcedureName()) && flag == 1) {
					CbrResult.potentialProcedures.put(ed.getProcedureName(), nse.getEval());
				}
			}
		}

	}

	public void postCycle() throws ExecutionException {

	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		return _caseBase;
	}

	public void predvidjajDijagnozu(int flag, Examination examination) {
		try {
			System.out.println("-----");
			this.flag = flag;
			this.configure();
			this.setSimilarityConfigrationForDiagnosis();
			this.preCycle();

			CBRQuery query = new CBRQuery();
			ExaminationDescription examinationDescription = new ExaminationDescription();

			// ovde zakucavas
//			examinationDescription.setDateOfBirth(23);
//			examinationDescription.setAbnormalInvoluntaryMovements("T");
//			examinationDescription.setDisturbanceOfMemory("F");
//			examinationDescription.setDisturbanceOfSmellAndTaste("F");
//			examinationDescription.setDizziness("F");
//			examinationDescription.setFocalWeakness("F");
//			examinationDescription.setHeadache("T");
//			examinationDescription.setLossOfSensation("F");
//			examinationDescription.setProblemsWithMovement("F");
//			examinationDescription.setSeizures("F");
//			examinationDescription.setPulse(80);
//			examinationDescription.setLowerBloodPressure(80);
//			examinationDescription.setUpperBloodPressure(120);
			
			int i = 0;
			if(examination.getPhysicalExamination().isAbnormalInvoluntaryMovements()) {
				examinationDescription.setAbnormalInvoluntaryMovements("T");
				i++;
			} else {
				examinationDescription.setAbnormalInvoluntaryMovements("F");
			}
			
			if(examination.getPersonalAnamnesis().isDisturbanceOfMemory()) {
				i++;
				examinationDescription.setDisturbanceOfMemory("T");	
			} else {
				examinationDescription.setDisturbanceOfMemory("F");
			}
			
			//dodaj u view i model pa onda i na osnovu ovog da je dinamicki
			examinationDescription.setDisturbanceOfSmellAndTaste("F");
			
			if(examination.getPhysicalExamination().isDizziness()) {
				i++;
				examinationDescription.setDizziness("T");	
			} else {
				examinationDescription.setDizziness("F");
			}
			
			if(examination.getPhysicalExamination().isFocalWeakness()) {
				i++;
				examinationDescription.setFocalWeakness("T");	
			} else {
				examinationDescription.setFocalWeakness("F");
			}
			
			if(examination.getPersonalAnamnesis().getHeadache() != HeadacheType.NoHeadche) {
				examinationDescription.setDisturbanceOfMemory("T");	
				i++;
			} else {
				examinationDescription.setDisturbanceOfMemory("F");
			}
			
			if(examination.getPhysicalExamination().isLossOfSensation()) {
				i++;
				examinationDescription.setLossOfSensation("T");	
			} else {
				examinationDescription.setLossOfSensation("F");
			}
			
			if(examination.getPhysicalExamination().isProblemsWithMovement()) {
				i++;
				examinationDescription.setProblemsWithMovement("T");	
			} else {
				examinationDescription.setProblemsWithMovement("F");
			}
			
			if(examination.getPhysicalExamination().isSeizures()) {
				i++;
				examinationDescription.setSeizures("T");	
			} else {
				examinationDescription.setSeizures("F");
			}
			System.out.println(i);
			examinationDescription.setDateOfBirth(Integer.parseInt(examination.getPatient().getDateOfBirth()));
			examinationDescription.setPulse(examination.getPhysicalExamination().getPulse());
			examinationDescription.setLowerBloodPressure(examination.getPhysicalExamination().getLowerBloodPressure());
			examinationDescription.setUpperBloodPressure(examination.getPhysicalExamination().getUpperBloodPressure());
			
			query.setDescription(examinationDescription);
			
			this.cycle(query);

			this.postCycle();

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public void predvidjajLekProceduru(int flag, Examination examination) {
		try {
			System.out.println("-----");
			this.flag = flag;
			this.configure();
			this.setSimilarityConfigrationForMedicationsAndProcedures();
			this.preCycle();

			CBRQuery query = new CBRQuery();
			ExaminationDescription examinationDescription = new ExaminationDescription();

			// ovde zakucavas, preuzmi iz examinationa
			/*examinationDescription.setDateOfBirth(23);
			examinationDescription.setPulse(80);
			examinationDescription.setLowerBloodPressure(80);
			examinationDescription.setUpperBloodPressure(120);
			examinationDescription.setDiagonsisName("stroke");*/
			
			examinationDescription.setDateOfBirth(Integer.parseInt(examination.getPatient().getDateOfBirth()));
			examinationDescription.setPulse(examination.getPhysicalExamination().getPulse());
			examinationDescription.setLowerBloodPressure(examination.getPhysicalExamination().getLowerBloodPressure());
			examinationDescription.setUpperBloodPressure(examination.getPhysicalExamination().getUpperBloodPressure());
			examinationDescription.setDiagonsisName(examination.getFinalDiagnosisModel().getDiagnosisName());

			query.setDescription(examinationDescription);
			this.cycle(query);
			this.postCycle();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
