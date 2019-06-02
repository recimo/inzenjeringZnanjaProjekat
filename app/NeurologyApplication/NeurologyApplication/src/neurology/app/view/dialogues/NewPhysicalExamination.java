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
import javax.swing.JTextField;

import neurology.app.model.Examination;
import neurology.app.model.PhysicalExamination;
import neurology.app.model.Symptom;
import neurology.app.model.anamnesis.Anamnesis;

public class NewPhysicalExamination extends JDialog {

	private static final long serialVersionUID = 1L;

	private Examination examination;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;

	private JLabel musclesRecognition;
	private JLabel visualAcuity;
	private JLabel musclesStrength;
	private JLabel pulse;
	private JLabel lowerBloodPressure;
	private JLabel upperBloodPressure;

	private JLabel problemsWithMovement;
	private JLabel abnormalInvoluntaryMovements;
	private JLabel seizures;
	private JLabel disturbanceOfMemory;
	private JLabel dizziness;
	private JLabel weakness;

	private JLabel pains;
	private JLabel kneePain;
	private JLabel hipPain;
	private JLabel backPain;
	private JLabel legPain;
	private JLabel chestPain;

	public JCheckBox musclesRecognitionCheck;
	public final String[] visual = { "1", "2", "3", "4", "5", "6", "7" };
	public JComboBox<String> visualAcuityCombo;
	public final String[] strength = { "0", "1", "2", "3", "4", "5" };
	public JComboBox<String> musclesStrengthCombo;
	public JTextField pulseField;
	public JTextField lowerBloodPressureField;
	public JTextField upperBloodPressureField;

	public JCheckBox problemsWithMovementCheck;
	public JCheckBox abnormalInvoluntaryMovementsCheck;
	public JCheckBox seizuresCheck;
	public JCheckBox disturbanceOfMemoryCheck;
	public JCheckBox dizzinessCheck;
	public JCheckBox weaknessCheck;

	private JLabel painsNull;
	public JCheckBox kneePainCheck;
	public JCheckBox hipPainCheck;
	public JCheckBox backPainCheck;
	public JCheckBox legPainCheck;
	public JCheckBox chestPainCheck;

	private JButton nextButton;
	private JButton resetButton;
	private JButton backButton;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public NewPhysicalExamination(Examination examination) {
		this.examination = examination;
		this.initDialog();

	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Physical");
		this.setPreferredSize(new Dimension(1280, 500));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanels();
	}

	public void initPanels() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new GridLayout(1, 3, 50, 50));

		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(new GridLayout(9, 2, 10, 30));

		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new GridLayout(9, 2, 10, 30));

		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new GridLayout(9, 2, 10, 30));

		this.mainPanel.add(leftPanel, BorderLayout.WEST);
		this.mainPanel.add(centerPanel, BorderLayout.CENTER);
		this.mainPanel.add(rightPanel, BorderLayout.EAST);

		this.initComponents();
		this.initActionListeners();

		this.add(mainPanel);

	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.initLeft();
		this.initCenter();
		this.initRight();

	}

	public void initLeft() {
		this.musclesRecognition = new JLabel("Muscles Recognition:");
		this.musclesRecognitionCheck = new JCheckBox();
		this.musclesRecognition.setPreferredSize(labelDim);

		this.leftPanel.add(musclesRecognition);
		this.leftPanel.add(musclesRecognitionCheck);

		this.visualAcuity = new JLabel("Visual Acuity (x/60):");
		this.visualAcuityCombo = new JComboBox<String>(visual);
		this.visualAcuity.setPreferredSize(labelDim);
		this.visualAcuityCombo.setPreferredSize(fieldDim);

		this.leftPanel.add(visualAcuity);
		this.leftPanel.add(visualAcuityCombo);

		this.musclesStrength = new JLabel("Muscles Strength:");
		this.musclesStrengthCombo = new JComboBox<String>(strength);
		this.musclesStrength.setPreferredSize(labelDim);
		this.musclesStrengthCombo.setPreferredSize(fieldDim);

		this.leftPanel.add(musclesStrength);
		this.leftPanel.add(musclesStrengthCombo);

		this.pulse = new JLabel("Pulse:");
		this.pulseField = new JTextField();
		this.pulse.setPreferredSize(labelDim);
		this.pulseField.setPreferredSize(fieldDim);

		this.leftPanel.add(pulse);
		this.leftPanel.add(pulseField);

		this.lowerBloodPressure = new JLabel("Lower Blood Pressure:");
		this.lowerBloodPressureField = new JTextField();
		this.lowerBloodPressure.setPreferredSize(labelDim);
		this.lowerBloodPressureField.setPreferredSize(fieldDim);

		this.leftPanel.add(lowerBloodPressure);
		this.leftPanel.add(lowerBloodPressureField);

		this.upperBloodPressure = new JLabel("Upper Blood Pressure:");
		this.upperBloodPressureField = new JTextField();
		this.upperBloodPressure.setPreferredSize(labelDim);
		this.upperBloodPressureField.setPreferredSize(fieldDim);

		this.leftPanel.add(upperBloodPressure);
		this.leftPanel.add(upperBloodPressureField);

		this.nextButton = new JButton("Next");
		this.nextButton.setPreferredSize(buttonDim);

		this.leftPanel.add(nextButton);
	}

	public void initCenter() {

		this.problemsWithMovement = new JLabel("Problems With Movement:");
		this.problemsWithMovementCheck = new JCheckBox();
		this.problemsWithMovement.setPreferredSize(labelDim);

		this.centerPanel.add(problemsWithMovement);
		this.centerPanel.add(problemsWithMovementCheck);

		this.abnormalInvoluntaryMovements = new JLabel("Abnormal Involuntary Movements:");
		this.abnormalInvoluntaryMovementsCheck = new JCheckBox();
		this.abnormalInvoluntaryMovements.setPreferredSize(labelDim);

		this.centerPanel.add(abnormalInvoluntaryMovements);
		this.centerPanel.add(abnormalInvoluntaryMovementsCheck);

		this.seizures = new JLabel("Seizures:");
		this.seizuresCheck = new JCheckBox();
		this.seizures.setPreferredSize(labelDim);

		this.centerPanel.add(seizures);
		this.centerPanel.add(seizuresCheck);

		this.disturbanceOfMemory = new JLabel("Disturbance Of Memory:");
		this.disturbanceOfMemoryCheck = new JCheckBox();
		this.disturbanceOfMemory.setPreferredSize(labelDim);

		this.centerPanel.add(disturbanceOfMemory);
		this.centerPanel.add(disturbanceOfMemoryCheck);

		this.dizziness = new JLabel("Dizziness:");
		this.dizzinessCheck = new JCheckBox();
		this.dizziness.setPreferredSize(labelDim);

		this.centerPanel.add(dizziness);
		this.centerPanel.add(dizzinessCheck);

		this.weakness = new JLabel("Weakness:");
		this.weaknessCheck = new JCheckBox();
		this.weakness.setPreferredSize(labelDim);

		this.centerPanel.add(weakness);
		this.centerPanel.add(weaknessCheck);

		this.resetButton = new JButton("Reset");
		this.resetButton.setPreferredSize(buttonDim);
		this.centerPanel.add(resetButton);

	}

	public void initRight() {

		this.pains = new JLabel("Pains:");
		this.painsNull = new JLabel();
		this.pains.setPreferredSize(labelDim);
		this.painsNull.setPreferredSize(labelDim);

		this.rightPanel.add(pains);
		this.rightPanel.add(painsNull);

		this.kneePain = new JLabel("Knew pain:");
		this.kneePainCheck = new JCheckBox();
		this.kneePain.setPreferredSize(labelDim);

		this.rightPanel.add(kneePain);
		this.rightPanel.add(kneePainCheck);

		this.hipPain = new JLabel("Hip Pain:");
		this.hipPainCheck = new JCheckBox();
		this.hipPain.setPreferredSize(labelDim);

		this.rightPanel.add(hipPain);
		this.rightPanel.add(hipPainCheck);

		this.backPain = new JLabel("Back Pain:");
		this.backPainCheck = new JCheckBox();
		this.backPain.setPreferredSize(labelDim);

		this.rightPanel.add(backPain);
		this.rightPanel.add(backPainCheck);

		this.legPain = new JLabel("Leg Pain:");
		this.legPainCheck = new JCheckBox();
		this.legPain.setPreferredSize(labelDim);

		this.rightPanel.add(legPain);
		this.rightPanel.add(legPainCheck);

		this.chestPain = new JLabel("ChestPain:");
		this.chestPainCheck = new JCheckBox();
		this.chestPain.setPreferredSize(labelDim);

		this.rightPanel.add(chestPain);
		this.rightPanel.add(chestPainCheck);

		this.backButton = new JButton("Back");
		this.backButton.setPreferredSize(buttonDim);

		this.rightPanel.add(backButton);
	}

	public void initActionListeners() {

		this.nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PhysicalExamination physicalExamination = new PhysicalExamination();
				
				//ovde preuzeti sve vrednosti koje je korisnik uneo i dodati i u psysical i u examination, sad ide zakucavanje
				//physicalExamination.setMusclesRecognition(NewPhysicalExamination.this.); 
				NewPhysicalExamination.this.examination.getSymptoms().add(new Symptom("headache"));
				NewPhysicalExamination.this.examination.getSymptoms().add(new Symptom("dizziness"));
				
				NewPhysicalExamination.this.examination.setPhysicalExamination(physicalExamination);
				NewAdditionalExamination newAdditional = new NewAdditionalExamination(examination);
				newAdditional.setVisible(true);
				
				dispose();
			}
		});

		this.resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		this.backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
