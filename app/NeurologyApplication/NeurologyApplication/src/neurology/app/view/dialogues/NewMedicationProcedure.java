package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import neurology.app.miscellaneous.MyMedProFinder;
import neurology.app.model.Examination;

public class NewMedicationProcedure extends JDialog {

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
				// this.examination.medication = izabran iz kombo boxa
				// this.examination.procedure = izabran iz kombo boxa
			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

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

	public boolean validation() {

		return true;
	}

}
