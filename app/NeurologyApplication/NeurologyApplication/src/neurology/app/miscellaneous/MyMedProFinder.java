package neurology.app.miscellaneous;

import java.util.ArrayList;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import neurology.app.model.DiagnosisModel;

public class MyMedProFinder {

	public static ArrayList<String> findMedications(DiagnosisModel diagnose) {
		ArrayList<String> retVal = new ArrayList<>();
		JIPEngine engine = new JIPEngine();

		engine.consultFile("data/facts/medications_and_procedures.pl");

		JIPQuery query = engine
				.openSynchronousQuery("medications_for_diagnose(" + diagnose.getDiagnosisName().toLowerCase() + ",X)");

		JIPTerm solution;
		while ((solution = query.nextSolution()) != null) {
			for (JIPVariable var : solution.getVariables()) {
				retVal.add(var.getValue().toString());
			}
		}

		return retVal;

	}

	public static ArrayList<String> findProcedures(DiagnosisModel diagnose) {
		ArrayList<String> retVal = new ArrayList<>();
		JIPEngine engine = new JIPEngine();

		engine.consultFile("data/facts/medications_and_procedures.pl");

		JIPQuery query = engine
				.openSynchronousQuery("procedures_for_diagnose(" + diagnose.getDiagnosisName().toLowerCase() + ",X)");

		JIPTerm solution;
		while ((solution = query.nextSolution()) != null) {
			for (JIPVariable var : solution.getVariables()) {
				retVal.add(var.getValue().toString());
				System.out.println(var.getValue().toString());
			}
		}

		return retVal;

	}

}
