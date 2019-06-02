package neurology.app.miscellaneous;

import java.util.ArrayList;
import java.util.List;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;

import neurology.app.model.Symptom;

public class MySymptomFinder {
	
	public static List<Symptom> findRelatedSymptoms(List<Symptom> symptoms) {
		List<Symptom> retVal = new ArrayList<>();
		JIPEngine engine = new JIPEngine();
		
		engine.consultFile("data/facts/related_symptoms.pl");
		for(Symptom symptom : symptoms) {
			JIPQuery query = engine.openSynchronousQuery("related_symptom("+symptom.getName()+",X,Y)");
			
			JIPTerm solution;
			while ( (solution = query.nextSolution()) != null) {
				int i = 0;
				for (JIPVariable var: solution.getVariables()) {
					if(i==0) {
						boolean toAdd = true;
						String str = var.getValue().toString();
						for(Symptom s : retVal) {
							if(s.getName().equals(str)) {
								toAdd = false;
							}
						}
						if(toAdd)
							retVal.add(new Symptom(str));
						
					}
					i++;
				}
			}	
		}
		
		
		return retVal;
	}

}
