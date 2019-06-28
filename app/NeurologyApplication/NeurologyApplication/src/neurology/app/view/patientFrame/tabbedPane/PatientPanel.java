package neurology.app.view.patientFrame.tabbedPane;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neurology.app.model.Patient;

public class PatientPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Patient patient;

	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel identificationNumberLabel;
	private JLabel dateOfBirthLabel;
	private JLabel genderOfPatientLabel;
	private JLabel rightHandedLabel;

	private JLabel firstName;
	private JLabel lastName;
	private JLabel identificationNumber;
	private JLabel dateOfBirth;
	private JLabel genderOfPatient;
	private JCheckBox rightHanded;

	private Dimension labelDim;

	public PatientPanel(Patient patient) {
		this.patient = patient;
		this.initPanel();

	}

	public void initPanel() {
		this.setLayout(new GridLayout(11, 4, 10, 30));
		this.initComponents();
	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);

		this.firstNameLabel = new JLabel("Firstname:");
		this.firstName = new JLabel(this.patient.getFirstName());
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstName.setPreferredSize(labelDim);

		this.add(firstNameLabel);
		this.add(firstName);

		this.lastNameLabel = new JLabel("Lastname:");
		this.lastName = new JLabel(this.patient.getLastName());
		this.lastNameLabel.setPreferredSize(labelDim);
		this.lastName.setPreferredSize(labelDim);

		this.add(lastNameLabel);
		this.add(lastName);

		this.identificationNumberLabel = new JLabel("ID:");
		this.identificationNumber = new JLabel(this.patient.getIdentificationNumber());
		this.identificationNumberLabel.setPreferredSize(labelDim);
		this.identificationNumber.setPreferredSize(labelDim);

		this.add(identificationNumberLabel);
		this.add(identificationNumber);

		this.dateOfBirthLabel = new JLabel("Date of birth:");
		this.dateOfBirth = new JLabel(this.patient.getDateOfBirth());
		this.dateOfBirthLabel.setPreferredSize(labelDim);
		this.dateOfBirth.setPreferredSize(labelDim);

		this.add(dateOfBirthLabel);
		this.add(dateOfBirth);

		this.genderOfPatientLabel = new JLabel("Gender:");
		this.genderOfPatient = new JLabel(this.patient.getGenderOfPatient().toString());
		this.genderOfPatientLabel.setPreferredSize(labelDim);
		this.genderOfPatient.setPreferredSize(labelDim);

		this.add(genderOfPatientLabel);
		this.add(genderOfPatient);

		this.rightHandedLabel = new JLabel("Right handed:");
		this.rightHanded = new JCheckBox();
		this.rightHanded.setSelected(this.patient.isRightHanded());
		this.rightHanded.setEnabled(false);
		this.rightHandedLabel.setPreferredSize(labelDim);

		this.add(rightHandedLabel);
		this.add(rightHanded);

	}

}
