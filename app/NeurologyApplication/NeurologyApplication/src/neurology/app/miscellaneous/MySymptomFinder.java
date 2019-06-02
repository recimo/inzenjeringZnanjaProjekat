package neurology.app.miscellaneous;

import java.io.File;
import java.util.ArrayList;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import neurology.app.model.Patient;
import neurology.app.model.Symptom;

public class MySymptomFinder {

	public static ArrayList<Symptom> findRelatedSymptoms(ArrayList<Symptom> symptoms) {
		ArrayList<Symptom> retVal = new ArrayList<>();
		JIPEngine engine = new JIPEngine();

		engine.consultFile("data/facts/related_symptoms.pl");
		for (Symptom symptom : symptoms) {
			JIPQuery query = engine.openSynchronousQuery("related_symptom(" + symptom.getName() + ",X,Y)");

			JIPTerm solution;
			while ((solution = query.nextSolution()) != null) {
				int i = 0;
				for (JIPVariable var : solution.getVariables()) {
					if (i == 0) {
						boolean toAdd = true;
						String str = var.getValue().toString();
						for (Symptom s : retVal) {
							if (s.getName().equals(str)) {
								toAdd = false;
							}
						}
						if (toAdd)
							retVal.add(new Symptom(str));

					}
					i++;
				}
			}
		}

		return retVal;
	}

	public static ArrayList<Symptom> getOnlyImportantSymptoms(ArrayList<Symptom> input, Patient patient) {

		ArrayList<Symptom> output = new ArrayList<>();
		FuzzyController fuzzyController = new FuzzyController();
		JIPEngine engine = new JIPEngine();
		
		

		for (Symptom symptom : input) {
			
			//ako fajl ne postoji, dodaj simptom svakako jer ne mozes da proveris da li je nevazan
			File f = new File("data/rules/" + symptom.getName() + ".pl");
			if(!f.exists() || f.isDirectory()) { 
			    output.add(symptom);
			    continue;
			}
			
			engine.consultFile("data/rules/" + symptom.getName() + ".pl");
			
			double agePoints = 1;
			double sexPoints = 1;
			double racePoints = 1;
			
			// mora za sad da bude broj godina
			String ageRule = symptom.getName() + "(" + patient.getDateOfBirth() + ",X)";

			//kad se promeni na boolean
			//String sexRule = symptom.getName() + "(" + patient.getGenderOfPatient() + ",X)"; 
			String sexRule = symptom.getName() + "(" + "0" + ",X)";
			
			//kada se doda rasa pacijenta
			//String raceRule = symptom.getName() + "(" + patient.getRace() + ",X)";
			String raceRule = symptom.getName() + "(" + "1" + ",X)";
			
			System.out.println(ageRule);
			
			JIPQuery query = engine.openSynchronousQuery(ageRule);

			JIPTerm solution;
			while ((solution = query.nextSolution()) != null) {
				for (JIPVariable var : solution.getVariables()) {
					String str = var.getValue().toString();
					agePoints = Double.parseDouble(str);
				}
			}
			
			query = engine.openSynchronousQuery(sexRule);

			while ((solution = query.nextSolution()) != null) {
				for (JIPVariable var : solution.getVariables()) {
					String str = var.getValue().toString();
					sexPoints = Double.parseDouble(str);
				}
			}
			
			query = engine.openSynchronousQuery(raceRule);

			while ((solution = query.nextSolution()) != null) {
				for (JIPVariable var : solution.getVariables()) {
					String str = var.getValue().toString();
					racePoints = Double.parseDouble(str);
				}
			}
			

			double result = fuzzyController.calculate(agePoints,sexPoints,racePoints);
			if(result > 72) {
				output.add(symptom);
			}
		}

		return output;
	}

}
