package neurology.app.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import neurology.app.model.ExaminationDescription;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class CsvConnector implements Connector {
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/zadatak2.csv")));
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();

				ExaminationDescription examDescription = new ExaminationDescription();
				examDescription.setIdentificationNumber(values[0]);
				examDescription.setDateOfBirth(Integer.parseInt(values[1]));
				examDescription.setAbnormalInvoluntaryMovements(values[2]);
				examDescription.setDisturbanceOfMemory(values[3]);
				examDescription.setDisturbanceOfSmellAndTaste(values[4]);
				examDescription.setDizziness(values[5]);
				examDescription.setFocalWeakness(values[6]);
				examDescription.setHeadache(values[7]);
				examDescription.setLossOfSensation(values[8]);
				examDescription.setProblemsWithMovement(values[9]);
				examDescription.setSeizures(values[10]);
				examDescription.setPulse(Integer.parseInt(values[11]));
				examDescription.setLowerBloodPressure(Integer.parseInt(values[12]));
				examDescription.setUpperBloodPressure(Integer.parseInt(values[13]));
				examDescription.setDiagonsisName(values[14]);
				examDescription.setProcedureName(values[15]);
				examDescription.setMedicationName(values[16]);
				
				cbrCase.setDescription(examDescription);
				cases.add(cbrCase);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}

	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}

}