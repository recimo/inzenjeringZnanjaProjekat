package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import neurology.app.controller.PatientCreateAction;
import neurology.app.enumerations.Gender;
import neurology.app.model.Patient;
import neurology.app.view.patientFrame.PatientFrame;
import neurology.app.view.patientFrame.tabbedPane.PatientPanel;
import neurology.app.view.patientFrame.tabbedPane.anamnesis.AnamnesisPanel;
import neurology.app.view.patientFrame.tabbedPane.diagnosis.DiagnosisPanel;

public class NewPatient extends JDialog {

	private static final long serialVersionUID = 1L;

	private Patient newPatient;

	private JPanel mainPanel;

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

	public NewPatient() {
		this.newPatient = new Patient();
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("New Patient");
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

		this.add(mainPanel, BorderLayout.CENTER);

		this.initComponents();
		this.initActionListeners();

	}

	public void initComponents() {
		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.firstNameLabel = new JLabel("Firstname:");
		this.firstNameField = new JTextField("Only letters are allowed.");
		this.firstNameLabel.setPreferredSize(labelDim);
		this.firstNameField.setPreferredSize(fieldDim);
		focusListener(this.firstNameField);
		keyListener(this.firstNameField, 2);

		this.mainPanel.add(firstNameLabel);
		this.mainPanel.add(firstNameField);

		this.lastNameLabel = new JLabel("Lastname:");
		this.lastNameField = new JTextField("Only letters are allowed.");
		this.lastNameLabel.setPreferredSize(labelDim);
		this.lastNameField.setPreferredSize(fieldDim);
		focusListener(this.lastNameField);
		keyListener(this.lastNameField, 2);

		this.mainPanel.add(lastNameLabel);
		this.mainPanel.add(lastNameField);

		this.identificationNumberLabel = new JLabel("Identification number:");
		this.identificationNumberField = new JTextField("Only numbers are allowed.");
		this.identificationNumberLabel.setPreferredSize(labelDim);
		this.identificationNumberField.setPreferredSize(fieldDim);
		focusListener(this.identificationNumberField);
		keyListener(this.identificationNumberField, 1);

		this.mainPanel.add(identificationNumberLabel);
		this.mainPanel.add(identificationNumberField);

		this.dateOfBirthLabel = new JLabel("Age:");
		this.dateOfBirthLabel.setPreferredSize(labelDim);
		this.dateOfBirthField = new JTextField("Only numbers are allowed.");
		this.dateOfBirthField.setPreferredSize(fieldDim);
		focusListener(this.dateOfBirthField);
		keyListener(this.dateOfBirthField, 1);

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

		JPanel panel = new JPanel();
		panel.add(okButton);
		panel.add(cancelButton);

		this.add(panel, BorderLayout.SOUTH);
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

					dispose();

					PatientFrame patientFrame = new PatientFrame(newPatient);
					patientFrame.action();
					PatientPanel patientPanel = new PatientPanel(newPatient);
					// sluzi za prikaz onih tabova
					AnamnesisPanel anamnesisPanel = new AnamnesisPanel(patientFrame.getPersonalAnamnesis(),
							patientFrame.getFamilyAnamnesis());

					DiagnosisPanel diagnosisPanel = new DiagnosisPanel(patientFrame.getDiagnosisModels());
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
	}

	public boolean validation() {
		if (this.firstNameField.getText().equals("")) {
			this.firstNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.firstNameField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.lastNameField.getText().equals("")) {
			this.lastNameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.lastNameField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.identificationNumberField.getText().equals("")) {
			this.identificationNumberField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.identificationNumberField.setToolTipText("The field can not be empty!");

			return false;
		} else if (this.dateOfBirthField.getText().equals("")) {
			this.dateOfBirthField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			this.dateOfBirthField.setToolTipText("The field can not be empty!");

			return false;
		}
		return true;
	}

	public void focusListener(JTextField textField) {
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				textField.setText("");
			}
		});
	}

	public void keyListener(JTextField textField, int option) {

		if (option == 1) {
			textField.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {

					if (!textField.getText().matches("^[0-9]+$")) {
						textField.setToolTipText("Only numbers are allowed!");
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					} else {
						textField.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
					}

				}
			});
		} else if (option == 2) {
			textField.addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {

					if (!textField.getText().matches("^[a-zA-Z]+$")) {
						textField.setToolTipText("Only letters are allowed!");
						textField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					} else {
						textField.setBorder(BorderFactory.createLineBorder(new Color(0, 204, 255), 2));
					}
				}
			});
		}

	}
}
