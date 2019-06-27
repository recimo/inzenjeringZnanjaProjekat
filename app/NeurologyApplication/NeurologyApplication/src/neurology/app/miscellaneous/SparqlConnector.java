package neurology.app.miscellaneous;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import neurology.app.enumerations.HeadacheType;
import neurology.app.model.Examination;
import neurology.app.model.ExaminationDescription;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;

public class SparqlConnector implements Connector {

	private ArrayList<Examination> examinations = new ArrayList<>();

	public SparqlConnector(ArrayList<Examination> e) {
		this.examinations = e;
	}

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();

		for(Examination examination : examinations) {
			CBRCase cbrCase = new CBRCase();

			ExaminationDescription examDescription = new ExaminationDescription();
			examDescription.setIdentificationNumber(examination.getPatient().getIdentificationNumber());
			examDescription.setDateOfBirth(Integer.parseInt(examination.getPatient().getDateOfBirth()));
			examDescription.setPulse(examination.getPhysicalExamination().getPulse());
			examDescription.setUpperBloodPressure(examination.getPhysicalExamination().getUpperBloodPressure());
			examDescription.setLowerBloodPressure(examination.getPhysicalExamination().getLowerBloodPressure());
			if(examination.getPhysicalExamination().isAbnormalInvoluntaryMovements()) {
				examDescription.setAbnormalInvoluntaryMovements("T");	
			} else {
				examDescription.setAbnormalInvoluntaryMovements("F");
			}
			if(examination.getPhysicalExamination().isDizziness()) {
				examDescription.setDizziness("T");	
			} else {
				examDescription.setDizziness("F");
			}
			if(examination.getPhysicalExamination().isFocalWeakness()) {
				examDescription.setFocalWeakness("T");	
			} else {
				examDescription.setFocalWeakness("F");
			}
			if(examination.getPhysicalExamination().isLossOfSensation()) {
				examDescription.setLossOfSensation("T");	
			} else {
				examDescription.setLossOfSensation("F");
			}
			if(examination.getPhysicalExamination().isProblemsWithMovement()) {
				examDescription.setProblemsWithMovement("T");	
			} else {
				examDescription.setProblemsWithMovement("F");
			}
			if(examination.getPhysicalExamination().isSeizures()) {
				examDescription.setSeizures("T");	
			} else {
				examDescription.setSeizures("F");
			}
			if(examination.getPersonalAnamnesis().isDisturbanceOfMemory()) {
				examDescription.setDisturbanceOfMemory("T");	
			} else {
				examDescription.setDisturbanceOfMemory("F");
			}
			
			if(examination.getPersonalAnamnesis().getHeadache() != HeadacheType.NoHeadche) {
				examDescription.setDisturbanceOfMemory("T");	
			} else {
				examDescription.setDisturbanceOfMemory("F");
			}
			
//			if(examination.getPhysycalExamination().isDisturbanceOfSmellAndTaste) {
//				examDescription.setDisturbanceOfSmellAndTaste("T");	
//			} else {
//				examDescription.setDisturbanceOfSmellAndTaste("F");
//			}
			examDescription.setDisturbanceOfSmellAndTaste("F");
//			
			examDescription.setDiagonsisName(examination.getFinalDiagnosisModel().getDiagnosisName());
			
			examDescription.setProcedureName(examination.getProcedure());
			
			examDescription.setMedicationName(examination.getMedication());

			cbrCase.setDescription(examDescription);
			cases.add(cbrCase);

		}
			
		return cases;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
		// TODO Auto-generated method stub
		
	}

}
