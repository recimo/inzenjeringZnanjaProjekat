package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import neurology.app.controller.PatientCreateAction;
import neurology.app.enumerations.Gender;
import neurology.app.model.Patient;
import neurology.app.view.patientFrame.PatientFrame;
import neurology.app.view.patientFrame.tabbedPane.AnamnesisPanel;
import neurology.app.view.patientFrame.tabbedPane.DiagnosisPanel;
import neurology.app.view.patientFrame.tabbedPane.PatientPanel;

public class NewMedicalExamination extends JDialog {

	private Patient newPatient;

	private JPanel mainPanel;
	private JPanel searchPanel;

	private JLabel searchLabel;
	private JTextField searchField;
	private JButton searchButton;

	private JLabel searchedNameLabel;
	private JLabel searchedLastnameLabel;
	private JLabel searchedDateLabel;

	private JLabel searchedName;
	private JLabel searchedLast;
	private JLabel searchedDate;

	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel identificationNumberLabel;
	private JLabel dateOfBirthLabel;
	private JLabel genderOfPatientLabel;
	private JLabel rightHandedLabel;

	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField identificationNumberField;
	private JTextField dateOfBirthField;
	private String[] gender = { Gender.Male.toString(), Gender.Female.toString() };
	private JComboBox<String> genderOfPatientField;
	private JCheckBox rightHandBox;

	private JButton okButton;
	private JButton cancelButton;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public NewMedicalExamination() {
		this.newPatient = new Patient();
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Patient");
		this.setPreferredSize(new Dimension(800, 500));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(9, 2, 10, 30));

		this.add(mainPanel, BorderLayout.WEST);

		this.searchPanel = new JPanel();
		this.searchPanel.setLayout(new FlowLayout());
		this.add(searchPanel, BorderLayout.EAST);
		this.initComponents();
		this.initActionListeners();

	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.searchLabel = new JLabel("Search:");
		this.searchField = new JTextField();
		this.searchButton = new JButton("...");
		this.searchLabel.setPreferredSize(labelDim);
		this.searchField.setPreferredSize(fieldDim);
		this.searchButton.setPreferredSize(new Dimension(25, 25));

		this.searchPanel.add(searchLabel);
		this.searchPanel.add(searchField);
		this.searchPanel.add(searchButton);

		this.firstNameLabel = new JLabel("Firstname:");
		this.firstNameField = new JTextField();
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

		this.mainPanel.add(firstNameLabel);
		this.mainPanel.add(firstNameField);

		this.lastNameLabel = new JLabel("Lastname:");
		this.lastNameField = new JTextField();
		this.lastNameLabel.setPreferredSize(labelDim);
		this.lastNameField.setPreferredSize(fieldDim);

		this.mainPanel.add(lastNameLabel);
		this.mainPanel.add(lastNameField);

		this.identificationNumberLabel = new JLabel("Identification number:");
		this.identificationNumberField = new JTextField();
		this.identificationNumberLabel.setPreferredSize(labelDim);
		this.identificationNumberField.setPreferredSize(fieldDim);

		this.mainPanel.add(identificationNumberLabel);
		this.mainPanel.add(identificationNumberField);

		this.dateOfBirthLabel = new JLabel("Date of birth:");
		this.dateOfBirthLabel.setPreferredSize(labelDim);
		this.dateOfBirthField = new JTextField();
		this.dateOfBirthField.setPreferredSize(fieldDim);

		this.mainPanel.add(dateOfBirthLabel);
		this.mainPanel.add(dateOfBirthField);

		this.genderOfPatientLabel = new JLabel("Gender:");
		this.genderOfPatientField = new JComboBox<String>(gender);
		this.genderOfPatientLabel.setPreferredSize(labelDim);
		this.genderOfPatientField.setPreferredSize(fieldDim);

		this.mainPanel.add(genderOfPatientLabel);
		this.mainPanel.add(genderOfPatientField);

		this.rightHandedLabel = new JLabel("Right handed?");
		this.rightHandBox = new JCheckBox();
		this.rightHandedLabel.setPreferredSize(labelDim);

		this.mainPanel.add(rightHandedLabel);
		this.mainPanel.add(rightHandBox);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

		this.mainPanel.add(okButton);
		this.mainPanel.add(cancelButton);

	}

	public void initActionListeners() {
		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validation()) {

					PatientCreateAction createAction = new PatientCreateAction();
					createAction.action(newPatient, firstNameField.getText(), lastNameField.getText(),
							identificationNumberField.getText(), dateOfBirthField.getText(),
							genderOfPatientField.getSelectedItem().toString(), rightHandBox.isSelected());

					print();
					dispose();

					NewAnamnesis newAnamnesisDialog = new NewAnamnesis(newPatient);
					newAnamnesisDialog.setVisible(true);

					PatientFrame patientFrame = new PatientFrame(newPatient);
					PatientPanel patientPanel = new PatientPanel(newPatient);

					AnamnesisPanel anamnesisPanel = new AnamnesisPanel();
					DiagnosisPanel diagnosisPanel = new DiagnosisPanel();
					patientFrame.initTabs(patientPanel, anamnesisPanel, diagnosisPanel);
					patientFrame.setVisible(true);
				}

			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// prosledi joj id pacijenta i pacijenta za inicijalizaciju

			}
		});
	}

	public boolean validation() {
		if (this.firstNameField.getText().equals("")) {
			this.firstNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			return false;
		} else if (this.lastNameField.getText().equals("")) {
			this.lastNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			return false;
		} else if (this.identificationNumberField.getText().equals("")) {
			this.identificationNumberField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			return false;
		} else if (this.dateOfBirthField.getText().equals("")) {
			this.dateOfBirthField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			return false;
		}
		return true;
	}

	public void print() {
		System.out.println("Patient");
		System.out.println(newPatient.getFirstName());
		System.out.println(newPatient.getLastName());
		System.out.println(newPatient.getIdentificationNumber());
		System.out.println(newPatient.getDateOfBirth());
		System.out.println(newPatient.getGenderOfPatient().toString());
		System.out.println(newPatient.isRightHanded());
	}

}
