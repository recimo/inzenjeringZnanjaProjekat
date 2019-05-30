package neurology.app.view.dialogues;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import neurology.app.model.Address;
import neurology.app.model.Patient;

public class AddNewPatientDialog extends JDialog {

	private Patient newPatient;
	private Address newAddress;

	private JPanel mainPanel;

	private JLabel personalDataLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel identificationNumberLabel;
	private JLabel dateOfBirthLabel;
	private JLabel genderOfPatientLabel;
	private JLabel contactNumberLabel;

	private JLabel addressLabel;

	private JLabel countryLabel;
	private JLabel cityLabel;
	private JLabel postalCodeLabel;
	private JLabel streetLabel;
	private JLabel numberLabel;
	private JLabel apartmentNumberLabel;

	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField identificationNumberField;
	private JTextField dateOfBirthField;
	private JTextField genderOfPatientField;
	private JTextField contactNumberField;

	private JTextField countryField;
	private JTextField cityField;
	private JTextField postalCodeField;
	private JTextField streetField;
	private JTextField numberField;
	private JTextField apartmentNumberField;

	private JButton okButton;
	private JButton cancelButton;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public AddNewPatientDialog() {

	}

	public void initDialog() {

	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(15, 2, 10, 30));

	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.personalDataLabel = new JLabel("Personal Data:");

		this.firstNameLabel = new JLabel("Firstname:");
		this.firstNameField = new JTextField();
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

		this.lastNameLabel = new JLabel("Lastname:");
		this.lastNameField = new JTextField();
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

		this.identificationNumberLabel = new JLabel("Identification number:");
		this.identificationNumberField = new JTextField();
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

		this.dateOfBirthLabel = new JLabel("Date of birth:");
		this.dateOfBirthField = new JTextField();
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

		this.genderOfPatientLabel = new JLabel("Gender:");
		this.genderOfPatientField = new JTextField();
		this.genderOfPatientLabel.setPreferredSize(labelDim);
		this.genderOfPatientField.setPreferredSize(fieldDim);

		this.contactNumberLabel = new JLabel("Contact number:");
		this.contactNumberField = new JTextField();
		this.contactNumberLabel.setPreferredSize(labelDim);
		this.contactNumberField.setPreferredSize(fieldDim);

		this.addressLabel = new JLabel("Address:");

		this.countryLabel = new JLabel("Country:");
		this.countryField = new JTextField();
		this.countryLabel.setPreferredSize(labelDim);
		this.countryField.setPreferredSize(fieldDim);

		this.cityLabel = new JLabel("City:");
		this.cityField = new JTextField();
		this.cityLabel.setPreferredSize(labelDim);
		this.cityField.setPreferredSize(fieldDim);

		this.postalCodeLabel = new JLabel("Postal code:");
		this.postalCodeField = new JTextField();
		this.postalCodeLabel.setPreferredSize(labelDim);
		this.postalCodeField.setPreferredSize(fieldDim);

		this.streetLabel = new JLabel("Street:");
		this.streetField = new JTextField();
		this.streetLabel.setPreferredSize(labelDim);
		this.streetField.setPreferredSize(fieldDim);

		this.numberLabel = new JLabel("Number:");
		this.numberField = new JTextField();
		this.numberLabel.setPreferredSize(labelDim);
		this.numberField.setPreferredSize(fieldDim);

		this.apartmentNumberLabel = new JLabel("Apartment number:");
		this.apartmentNumberField = new JTextField();
		this.apartmentNumberLabel.setPreferredSize(labelDim);
		this.apartmentNumberField.setPreferredSize(fieldDim);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);

	}

}
