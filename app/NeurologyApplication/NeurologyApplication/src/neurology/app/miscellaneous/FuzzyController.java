package neurology.app.miscellaneous;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.JFuzzyLogic;

public class FuzzyController {
	
	private static final String fclFilename = "data/fuzzy/fuzzy.fcl";
	
	public FuzzyController() {}
	
	public double calculate(double age, double sex, double race) {
		String args[] = { "-noCharts", "-e", fclFilename, ""+age, ""+sex, ""+race };
		
		JFuzzyLogic jFuzzyLogic = new JFuzzyLogic(args);
		jFuzzyLogic.run();
		
		FIS fis = jFuzzyLogic.getFis();  // Fuzzy Inference System

        double result = fis.getVariable("result").getValue();
        
        //System.out.println("Rezultat iz fuzzy logike je: " + result);
        return result;
    }

}
