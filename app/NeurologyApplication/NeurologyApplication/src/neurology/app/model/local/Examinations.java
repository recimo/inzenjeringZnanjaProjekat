package neurology.app.model.local;

import java.util.ArrayList;

import neurology.app.model.Examination;

public class Examinations {

	private ArrayList<Examination> examinations;

	public Examinations() {
		this.examinations = new ArrayList<Examination>();
	}

	public ArrayList<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(ArrayList<Examination> examinations) {
		this.examinations = examinations;
	}

}