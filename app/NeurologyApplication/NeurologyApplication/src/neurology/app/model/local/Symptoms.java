package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.Symptom;

public class Symptoms {

	private ArrayList<Symptom> sympotms;

	public Symptoms() {
		this.sympotms = new ArrayList<Symptom>();
	}

	public ArrayList<Symptom> getSympotms() {
		return sympotms;
	}

	public void setSympotms(ArrayList<Symptom> sympotms) {
		this.sympotms = sympotms;
	}

}