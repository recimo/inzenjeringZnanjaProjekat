package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neurology.app.controller.FamilyAnamnesisCreateAction;
import neurology.app.controller.PersonalAnamnesisCreateAction;
import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;
import neurology.app.model.Examination;
import neurology.app.model.Patient;
import neurology.app.model.anamnesis.Anamnesis;
import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class NewAnamnesis extends JDialog {

	private PersonalAnamnesis newPersonalAnamnesis;
	private FamilyAnamnesis newFamilyAnamnesis;
	private Patient patient;

	private Anamnesis newAnamnesis;

	private JPanel familyPanel;

	private JLabel diabetesLabel;
	private JLabel endocrineDiseasesLabel;
	private JLabel hypertensionLabel;
	private JLabel cerebrovascularDiseasesLabel;
	private JLabel headacheFamilyLabel;
	private JLabel mentalIllnessesLable;

	private JCheckBox diabetesCheck;
	private JCheckBox endoCheck;
	private JCheckBox hyperCheck;
	private JCheckBox cereCheck;
	private JCheckBox headCheck;
	private JCheckBox mentalCheck;

	private JPanel mainPanel;

	private JLabel lackOfEnergyAndInterestLabel;
	private JLabel disturbanceOfMemoryLabel;
	private JLabel headacheLabel; // combo box
	private JLabel sightLabel; // combo box
	private JLabel hearingLossLabel;
	private JLabel balanceLossLabel;
	private JLabel limbsPainLabel;

	private JCheckBox lackOfEnergyAndInterestCheckBox;
	private JCheckBox disturbanceOfMemoryCheckBox;
	private JComboBox<String> headacheField;
	private JComboBox<String> sightField;
	private JCheckBox hearingLossCheckBox;
	private JCheckBox balanceLossCheckBox;
	private JCheckBox limbsPainCheckBox;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	private JButton okButton;
	private JButton cancelButton;

	private String[] headacheType = { HeadacheType.NoHeadche.toString(), HeadacheType.Pulsating.toString(),
			HeadacheType.Pressure.toString(), HeadacheType.Tearing.toString(), HeadacheType.Flank.toString() };

	private String[] changeOfSight = { ChangeOfSight.Blur.toString(), ChangeOfSight.DoubleVision.toString(),
			ChangeOfSight.LoosingSightFull.toString(), ChangeOfSight.LoosingSightHalf.toString() };

	public NewAnamnesis(Patient patient) {
		this.newPersonalAnamnesis = new PersonalAnamnesis();
		this.newFamilyAnamnesis = new FamilyAnamnesis();
		this.patient = patient;
		this.newAnamnesis = new Anamnesis();
		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Anamnesis");
		this.setPreferredSize(new Dimension(650, 600));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}

	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(11, 2, 10, 30));

		this.familyPanel = new JPanel();
		this.familyPanel.setLayout(new GridLayout(11, 2, 10, 30));

		this.add(mainPanel, BorderLayout.WEST);
		this.add(familyPanel, BorderLayout.EAST);

		this.initComponents();
		this.initActionListeners();
	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.diabetesLabel = new JLabel("Diabetes?");
		this.diabetesCheck = new JCheckBox();
		this.diabetesLabel.setPreferredSize(labelDim);

		this.familyPanel.add(diabetesLabel);
		this.familyPanel.add(diabetesCheck);

		this.endocrineDiseasesLabel = new JLabel("Endocrine diseases?");
		this.endoCheck = new JCheckBox();
		this.endocrineDiseasesLabel.setPreferredSize(labelDim);

		this.familyPanel.add(endocrineDiseasesLabel);
		this.familyPanel.add(endoCheck);

		this.hypertensionLabel = new JLabel("Hypertenion?");
		this.hyperCheck = new JCheckBox();
		this.hypertensionLabel.setPreferredSize(labelDim);

		this.familyPanel.add(hypertensionLabel);
		this.familyPanel.add(hyperCheck);

		this.cerebrovascularDiseasesLabel = new JLabel("Cerebrovascular?");
		this.cereCheck = new JCheckBox();
		this.cerebrovascularDiseasesLabel.setPreferredSize(labelDim);

		this.familyPanel.add(cerebrovascularDiseasesLabel);
		this.familyPanel.add(cereCheck);

		this.headacheFamilyLabel = new JLabel("Headache?");
		this.headCheck = new JCheckBox();
		this.headacheFamilyLabel.setPreferredSize(labelDim);

		this.familyPanel.add(headacheFamilyLabel);
		this.familyPanel.add(headCheck);

		this.mentalIllnessesLable = new JLabel("Mental Illnesses?");
		this.mentalCheck = new JCheckBox();
		this.mentalIllnessesLable.setPreferredSize(labelDim);

		this.familyPanel.add(mentalIllnessesLable);
		this.familyPanel.add(mentalCheck);

		// personal

		this.lackOfEnergyAndInterestLabel = new JLabel("Lack of energy/interest?");
		this.lackOfEnergyAndInterestCheckBox = new JCheckBox();
		this.lackOfEnergyAndInterestLabel.setPreferredSize(labelDim);

		this.mainPanel.add(lackOfEnergyAndInterestLabel);
		this.mainPanel.add(lackOfEnergyAndInterestCheckBox);

		this.disturbanceOfMemoryLabel = new JLabel("Disturbance of memory?");
		this.disturbanceOfMemoryCheckBox = new JCheckBox();
		this.disturbanceOfMemoryLabel.setPreferredSize(labelDim);

		this.mainPanel.add(disturbanceOfMemoryLabel);
		this.mainPanel.add(disturbanceOfMemoryCheckBox);

		this.headacheLabel = new JLabel("Headache type:");
		this.headacheField = new JComboBox<String>(headacheType);
		this.headacheLabel.setPreferredSize(labelDim);
		this.headacheField.setPreferredSize(fieldDim);

		this.mainPanel.add(headacheLabel);
		this.mainPanel.add(headacheField);

		this.sightLabel = new JLabel("Sight:");
		this.sightField = new JComboBox<String>(changeOfSight);
		this.sightLabel.setPreferredSize(labelDim);
		this.sightField.setPreferredSize(fieldDim);

		this.mainPanel.add(sightLabel);
		this.mainPanel.add(sightField);

		this.hearingLossLabel = new JLabel("Hearing loss?");
		this.hearingLossCheckBox = new JCheckBox();
		this.hearingLossLabel.setPreferredSize(labelDim);

		this.mainPanel.add(hearingLossLabel);
		this.mainPanel.add(hearingLossCheckBox);

		this.balanceLossLabel = new JLabel("Balance loss?");
		this.balanceLossCheckBox = new JCheckBox();
		this.balanceLossLabel.setPreferredSize(labelDim);

		this.mainPanel.add(balanceLossLabel);
		this.mainPanel.add(balanceLossCheckBox);

		this.limbsPainLabel = new JLabel("Limbs pain?");
		this.limbsPainCheckBox = new JCheckBox();
		this.limbsPainLabel.setPreferredSize(labelDim);

		this.mainPanel.add(limbsPainLabel);
		this.mainPanel.add(limbsPainCheckBox);

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
					
					Examination examination = new Examination();
					examination.setPatient(patient);
					
					PersonalAnamnesisCreateAction createAction = new PersonalAnamnesisCreateAction();
					createAction.action(newPersonalAnamnesis,lackOfEnergyAndInterestCheckBox.isSelected(),
							disturbanceOfMemoryCheckBox.isSelected(), headacheField.getSelectedItem().toString(),
							sightField.getSelectedItem().toString(), hearingLossCheckBox.isSelected(),
							balanceLossCheckBox.isSelected(), limbsPainCheckBox.isSelected(),examination);

					FamilyAnamnesisCreateAction familyCreateAction = new FamilyAnamnesisCreateAction();
					familyCreateAction.action(newFamilyAnamnesis, diabetesCheck.isSelected(), endoCheck.isSelected(),
							hyperCheck.isSelected(), cereCheck.isSelected(), headCheck.isSelected(),
							mentalCheck.isSelected());

					newAnamnesis.setPersonalAnamnesis(newPersonalAnamnesis);
					newAnamnesis.setFamilyAnamnesis(newFamilyAnamnesis);
					newAnamnesis.setPatient(patient);
					
					examination.setAnamnesis(newAnamnesis);
					
					//dodati u simptome nesto ako treba

					NewPhysicalExamination newPhysical = new NewPhysicalExamination(examination);
					newPhysical.setVisible(true);
					
					dispose();

					
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

		return true;
	}

}
