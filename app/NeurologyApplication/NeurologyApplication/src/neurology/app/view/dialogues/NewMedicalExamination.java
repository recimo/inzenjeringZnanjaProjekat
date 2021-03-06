package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import neurology.app.GetAll;
import neurology.app.InitAll;
import neurology.app.controller.PatientCreateAction;
import neurology.app.controller.PatientSearchAction;
import neurology.app.enumerations.Gender;
import neurology.app.model.Examination;
import neurology.app.model.Patient;
import neurology.app.view.patientFrame.PatientFrame;
import neurology.app.view.patientFrame.tabbedPane.PatientPanel;
import neurology.app.view.patientFrame.tabbedPane.anamnesis.AnamnesisPanel;
import neurology.app.view.patientFrame.tabbedPane.diagnosis.DiagnosisPanel;

public class NewMedicalExamination extends JDialog {

	private static final long serialVersionUID = 1L;
	private Patient newPatient;
	private Examination examination;

	private JPanel mainPanel;
	private JPanel searchPanel;

	private JLabel searchLabel;
	private JTextField searchField;
	private JButton searchButton;

	private JButton profileButton;
	private JButton createPatient;

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
		this.examination = new Examination();
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
		this.searchField = new JTextField("Only numbers are allowed.");
		this.searchButton = new JButton("...");
		this.searchLabel.setPreferredSize(labelDim);
		this.searchField.setPreferredSize(fieldDim);
		this.searchButton.setPreferredSize(new Dimension(25, 25));
		focusListener(this.searchField);
		keyListener(this.searchField, 1);

		this.profileButton = new JButton("Medical carton");
		this.profileButton.setPreferredSize(buttonDim);
		this.profileButton.setEnabled(false);

		this.searchPanel.add(searchLabel);
		this.searchPanel.add(searchField);
		this.searchPanel.add(searchButton);
		this.searchPanel.add(profileButton);

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

		this.createPatient = new JButton("Create patient");
		this.createPatient.setPreferredSize(buttonDim);
		this.mainPanel.add(createPatient);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);
		this.okButton.setEnabled(false);

		JPanel panel = new JPanel();
		panel.add(okButton);
		panel.add(cancelButton);

		this.add(panel, BorderLayout.SOUTH);

	}

	public void initActionListeners() {
		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

				examination.setPatient(newPatient);

				NewAnamnesis newAnamnesisDialog = new NewAnamnesis(examination);
				newAnamnesisDialog.setVisible(true);

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
				if (searchField.getText().equals("")) {
					searchField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					PatientSearchAction psa = new PatientSearchAction();
					psa.action(searchField.getText());
					

					try {
						newPatient = psa.getPatient();
						profileButton.setEnabled(true);
						okButton.setEnabled(true);
					} catch (Exception e) {
						System.out.println("puko pacijent");
					}
				}

			}

		});

		this.profileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

		this.createPatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validation()) {
					PatientCreateAction createAction = new PatientCreateAction();
					createAction.action(newPatient, firstNameField.getText(), lastNameField.getText(),
							identificationNumberField.getText(), dateOfBirthField.getText(),
							genderOfPatientField.getSelectedItem().toString(), rightHandBox.isSelected());

					okButton.setEnabled(true);

					GetAll getAll = new GetAll();
					getAll.action();

					InitAll initAll = new InitAll();
					initAll.action();

					JOptionPane.showMessageDialog(null,
							"Patient: " + newPatient.getFirstName() + " " + newPatient.getLastName()
									+ " successfuly created. You can find him using search in future examinations.",
							"Successful creation", JOptionPane.INFORMATION_MESSAGE);
				}

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

	public void print() {
		System.out.println("Patient");
		System.out.println(newPatient.getFirstName());
		System.out.println(newPatient.getLastName());
		System.out.println(newPatient.getIdentificationNumber());
		System.out.println(newPatient.getDateOfBirth());
		System.out.println(newPatient.getGenderOfPatient().toString());
		System.out.println(newPatient.isRightHanded());
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
