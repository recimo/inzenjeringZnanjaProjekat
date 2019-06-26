package neurology.app.controller.dataBase.examination.get;

import neurology.app.model.local.AnamnesisFamily;

public class GetFamilyAnamnesis {
	
	private static final String QUERY_URL = "http://localhost:3030/inz/sparql";
	private static final String PREFIX = "PREFIX na: <http://www.neurologyapp.com/na#> PREFIX xsd: <http://w3.org/2001/XMLSchema#>";

	private AnamnesisFamily anamnesisFamily;
	
	public GetFamilyAnamnesis() {
		this.anamnesisFamily = new AnamnesisFamily();
	}
	
	public boolean getFamilyAnamnesis() {
		
		return false;
	}
	
}
