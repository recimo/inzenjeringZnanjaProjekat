package neurology.app;

import neurology.app.model.local.AnamnesisFamily;
import neurology.app.model.local.AnamnesisPersonal;
import neurology.app.model.local.DiagnosisModels;
import neurology.app.model.local.Examinations;
import neurology.app.model.local.Patients;
import neurology.app.model.local.PhysicalExaminations;
import neurology.app.model.local.Symptoms;
import neurology.app.view.mainFrame.MainFrame;

public class Singleton {

	private static Singleton instance = new Singleton();

	private MainFrame mainFrame;
	private Patients patients;
	private Examinations examinations;
	private AnamnesisPersonal anamnesisPersonal;
	private AnamnesisFamily anamnesisFamily;
	private DiagnosisModels diagnosisModels;
	private Symptoms symptoms;
	private PhysicalExaminations physicalExaminations;

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

	public AnamnesisFamily getAnamnesisFamily() {
		return anamnesisFamily;
	}

	public void setAnamnesisFamily(AnamnesisFamily anamnesisFamily) {
		this.anamnesisFamily = anamnesisFamily;
	}

	public DiagnosisModels getDiagnosisModels() {
		return diagnosisModels;
	}

	public void setDiagnosisModels(DiagnosisModels diagnosisModels) {
		this.diagnosisModels = diagnosisModels;
	}

	public Symptoms getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Symptoms symptoms) {
		this.symptoms = symptoms;
	}

	public PhysicalExaminations getPhysicalExaminations() {
		return physicalExaminations;
	}

	public void setPhysicalExaminations(PhysicalExaminations physicalExaminations) {
		this.physicalExaminations = physicalExaminations;
	}
	
}