package neurology.app.view.patientFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import neurology.app.controller.PatientGetDataAction;
import neurology.app.model.Patient;
import neurology.app.model.local.AnamnesisFamily;
import neurology.app.model.local.AnamnesisPersonal;
import neurology.app.model.local.DiagnosisModels;
import neurology.app.view.patientFrame.tabbedPane.PatientPanel;
import neurology.app.view.patientFrame.tabbedPane.TabbedPane;
import neurology.app.view.patientFrame.tabbedPane.anamnesis.AnamnesisPanel;
import neurology.app.view.patientFrame.tabbedPane.diagnosis.DiagnosisPanel;

public class PatientFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Patient patient;

	private JPanel mainPanel;
	private TabbedPane tabbedPane;
	private PatientPanel patientTab;
	private AnamnesisPanel anamnesisTab;
	private DiagnosisPanel diagnosisTab;

	private AnamnesisPersonal personalAnamnesis;
	private AnamnesisFamily familyAnamnesis;
	private DiagnosisModels diagnosisModels;

	public PatientFrame(Patient patient) {
		this.patient = patient;
		this.action();
		this.initFrame();

	}

	public void initFrame() {
		this.setPreferredSize(new Dimension(800, 500));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());

	}

	public void initTabs(PatientPanel patientTab, AnamnesisPanel anamnesisTab, DiagnosisPanel diagnosisTab) {
		this.tabbedPane = new TabbedPane();

		this.patientTab = patientTab;
		this.anamnesisTab = anamnesisTab;
		this.diagnosisTab = diagnosisTab;

		this.tabbedPane.addTab("Personal data", this.patientTab);
		this.tabbedPane.addTab("Anamnesis history", this.anamnesisTab);
		this.tabbedPane.addTab("Diagnosis history", this.diagnosisTab);
		// SwingUtilities.updateComponentTreeUI(this.mainPanel);

		this.mainPanel.add(tabbedPane);
		this.add(mainPanel);

	}

	public PatientPanel getPatientTab() {
		return patientTab;
	}

	public void setPatientTab(PatientPanel patientTab) {
		this.patientTab = patientTab;
	}

	public AnamnesisPanel getAnamnesisTab() {
		return anamnesisTab;
	}

	public void setAnamnesisTab(AnamnesisPanel anamnesisTab) {
		this.anamnesisTab = anamnesisTab;
	}

	public DiagnosisPanel getDiagnosisTab() {
		return diagnosisTab;
	}

	public void setDiagnosisTab(DiagnosisPanel diagnosisTab) {
		this.diagnosisTab = diagnosisTab;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void action() {
		PatientGetDataAction getData = new PatientGetDataAction(this.patient);
		getData.action();

		this.personalAnamnesis = getData.getPersonalAnamnesis();
		this.familyAnamnesis = getData.getFamilyAnamnesis();
		this.diagnosisModels = getData.getDiagnosisModels();
	}

	public AnamnesisPersonal getPersonalAnamnesis() {
		return personalAnamnesis;
	}

	public void setPersonalAnamnesis(AnamnesisPersonal personalAnamnesis) {
		this.personalAnamnesis = personalAnamnesis;
	}

	public AnamnesisFamily getFamilyAnamnesis() {
		return familyAnamnesis;
	}

	public void setFamilyAnamnesis(AnamnesisFamily familyAnamnesis) {
		this.familyAnamnesis = familyAnamnesis;
	}

	public DiagnosisModels getDiagnosisModels() {
		return diagnosisModels;
	}

	public void setDiagnosisModels(DiagnosisModels diagnosisModels) {
		this.diagnosisModels = diagnosisModels;
	}

}
