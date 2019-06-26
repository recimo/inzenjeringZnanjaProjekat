package neurology.app;

import neurology.app.model.local.AnamnesisPersonal;
import neurology.app.model.local.Examinations;
import neurology.app.model.local.Patients;
import neurology.app.view.mainFrame.MainFrame;

public class Singleton {

	private static Singleton instance = new Singleton();

	private MainFrame mainFrame;
	private Patients patients;
	private Examinations examinations;
	private AnamnesisPersonal anamnesisPersonal;

	private Singleton() {

	}

	public static Singleton getInstance() {
		return instance;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Patients getPatients() {
		return patients;
	}

	public void setPatients(Patients patients) {
		this.patients = patients;
	}

	public Examinations getExaminations() {
		return examinations;
	}

	public void setExaminations(Examinations examinations) {
		this.examinations = examinations;
	}

	public AnamnesisPersonal getAnamnesisPersonal() {
		return anamnesisPersonal;
	}

	public void setAnamnesisPersonal(AnamnesisPersonal anamnesisPersonal) {
		this.anamnesisPersonal = anamnesisPersonal;
	}

}