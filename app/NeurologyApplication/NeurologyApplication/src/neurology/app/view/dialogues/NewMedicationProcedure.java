package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import neurology.app.GetAll;
import neurology.app.InitAll;
import neurology.app.controller.dataBase.examination.insert.InsertDiagnosisModel;
import neurology.app.controller.dataBase.examination.insert.InsertExamination;
import neurology.app.controller.dataBase.examination.insert.InsertFamilyAnamnesis;
import neurology.app.controller.dataBase.examination.insert.InsertPersonalAnamnesis;
import neurology.app.controller.dataBase.examination.insert.InsertPhysicalExamination;
import neurology.app.controller.dataBase.examination.insert.InsertSymptom;
import neurology.app.controller.dataBase.patient.InsertPatient;
import neurology.app.miscellaneous.MyMedProFinder;
import neurology.app.model.Examination;
import neurology.app.model.Symptom;

public class NewMedicationProcedure extends JDialog {

	private static final long serialVersionUID = 1L;
	private Examination examination;
	private JPanel mainPanel;

	private JLabel chooseMedication;
	private JLabel chooseProcedure;

	public JComboBox<String> possibleMedicationsCombo;
	public JComboBox<String> possibleProceduresCombo;

	public ArrayList<String> calculatedMedications;
	public ArrayList<String> calculatedProcedures;

	private JButton okButton;
	private JButton cancelButton;
	private JButton backButton = new JButton();

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public NewMedicationProcedure(Examination examination) {
		this.examination = examination;

		calculatedMedications = MyMedProFinder.findMedications(examination.getFinalDiagnosisModel());
		calculatedProcedures = MyMedProFinder.findProcedures(examination.getFinalDiagnosisModel());

		for (String med : calculatedMedications) {
			System.out.println("MEDICATION: " + med);
		}

		for (String med : calculatedProcedures) {
			System.out.println("PROCEDURE: " + med);
		}
		
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Procedures and Medications");
		this.setPreferredSize(new Dimension(500, 400));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(7, 2, 10, 30));

		this.add(mainPanel, BorderLayout.CENTER);

		this.initComponents();
		this.initActionListeners();

	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(100, 25);

		this.chooseMedication = new JLabel("Choose Medication:");
		this.chooseMedication.setPreferredSize(labelDim);

		String[] medications = new String[calculatedMedications.size()];
		medications = calculatedMedications.toArray(medications);
		this.possibleMedicationsCombo = new JComboBox<String>(medications);
		this.possibleMedicationsCombo.setPreferredSize(fieldDim);

		this.mainPanel.add(chooseMedication);
		this.mainPanel.add(possibleMedicationsCombo);

		this.chooseProcedure = new JLabel("Choose Procedure:");
		this.chooseProcedure.setPreferredSize(labelDim);

		String[] procedures = new String[calculatedProcedures.size()];
		procedures = calculatedProcedures.toArray(procedures);
		this.possibleProceduresCombo = new JComboBox<String>(procedures);
		this.possibleProceduresCombo.setPreferredSize(fieldDim);

		this.mainPanel.add(chooseProcedure);
		this.mainPanel.add(possibleProceduresCombo);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

		JPanel panel = new JPanel();

		panel.add(okButton);
		panel.add(cancelButton);
		this.add(panel, BorderLayout.SOUTH);

	}

	public void initActionListeners() {

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				examination.setMedication(possibleMedicationsCombo.getSelectedItem().toString());
				examination.setProcedure(possibleProceduresCombo.getSelectedItem().toString());

				InsertPatient insert = new InsertPatient(examination.getPatient());
				insert.insert();

				InsertExamination insertExamination = new InsertExamination(examination);
				insertExamination.insert();
				examination.setId(insertExamination.getId());

				InsertPersonalAnamnesis insertPersonalAnamnesis = new InsertPersonalAnamnesis(
						examination.getPersonalAnamnesis(), examination.getId());
				insertPersonalAnamnesis.insert();

				InsertFamilyAnamnesis insertFamilyAnamnesis = new InsertFamilyAnamnesis(
						examination.getFamilyAnamnesis(), examination.getId());
				insertFamilyAnamnesis.insert();

				InsertPhysicalExamination insertPhysicalExamination = new InsertPhysicalExamination(
						examination.getPhysicalExamination(), examination.getId());
				insertPhysicalExamination.insert();

				for (Symptom sympton : examination.getAdditionalExamination().getSymptomsToCheck()) {
					InsertSymptom insertSymptom = new InsertSymptom(sympton, examination.getId());
					insertSymptom.insert();
				}

				InsertDiagnosisModel insertDiagnosisModel = new InsertDiagnosisModel(
						examination.getFinalDiagnosisModel(), examination.getId());
				insertDiagnosisModel.insert();

				GetAll getAll = new GetAll();
				getAll.action();

				InitAll initAll = new InitAll();
				initAll.action();
				JOptionPane.showMessageDialog(null, "End of examination");
				dispose();
			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					NewDiagnosis nd = new NewDiagnosis(NewMedicationProcedure.this.examination);
					nd.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// e1.printStackTrace();
				}
			}
		});
	}

	public boolean validation() {

		return true;
	}

}
