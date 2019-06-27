package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import neurology.app.miscellaneous.CBRFinder;
import neurology.app.miscellaneous.CbrResult;
import neurology.app.model.Examination;

public class NewMedicationProcedureCaseBased extends JDialog{
	
	private Examination examination;
	private JPanel mainPanel;

	private JLabel chooseMedication;
	private JLabel chooseProcedure;

	public JComboBox<String> possibleMedicationsCombo;
	public JComboBox<String> possibleProceduresCombo;

	public ArrayList<String> calculatedMedications = new ArrayList<String>();
	public ArrayList<String> calculatedProcedures = new ArrayList<String>();
	
	public ArrayList<Double> calculatedMedicationsPercentages = new ArrayList<Double>();
	public ArrayList<Double> calculatedProceduresPercantages = new ArrayList<Double>();
	
	public String selectedProcedure;
	public String selectedMedication;

	private JButton okButton;
	private JButton cancelButton;
	private JButton backButton;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public NewMedicationProcedureCaseBased(Examination examination) {
		this.examination = examination;

		CBRFinder recommender = new CBRFinder();
		recommender.predvidjajLekProceduru(1, this.examination); //1 da bi znao cycle za da treba da predvidja medication i procedure, jer cycle ne sme parametre da prima
		
		Iterator it = CbrResult.potentialMedications.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			calculatedMedications.add((String) pair.getKey());
			calculatedMedicationsPercentages.add((Double) pair.getValue());
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
		
		Iterator it2 = CbrResult.potentialProcedures.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry pair = (Map.Entry) it2.next();
			calculatedProcedures.add((String) pair.getKey());
			calculatedProceduresPercantages.add((Double) pair.getValue());
			System.out.println(pair.getKey() + " = " + pair.getValue());
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

		this.backButton = new JButton("Back");
		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.backButton.setPreferredSize(buttonDim);
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

		JPanel panel = new JPanel();

		panel.add(backButton);
		panel.add(okButton);
		panel.add(cancelButton);
		this.add(panel, BorderLayout.SOUTH);
		
		//kada se baza napravi onda iz baze dijagnoze
		selectedProcedure = possibleProceduresCombo.getSelectedItem().toString();
		selectedMedication = possibleMedicationsCombo.getSelectedItem().toString();
	}

	public void initActionListeners() {

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				examination.setProcedure(selectedProcedure);
				examination.setMedication(selectedMedication);

				System.out.println("Examination  : ");
				System.out.println("Dijagnoza : " + examination.getFinalDiagnosisModel().getDiagnosisName());
				System.out.println("Medication : " + examination.getMedication());
				System.out.println("Procedure : " + examination.getProcedure());
				
				//dodaj u bazu examination
				JOptionPane.showMessageDialog(null, "End of examination");
				dispose();
			}
		});
		
		this.possibleMedicationsCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedMedication =  possibleMedicationsCombo.getSelectedItem().toString();
				//selectedDiagnosis = baza.getDiagnosis(possibleDiagnosis.getSelectedItem()) kada se baza uradi
			}
			
		});
		
		this.possibleProceduresCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedProcedure =  possibleProceduresCombo.getSelectedItem().toString();
				//selectedDiagnosis = baza.getDiagnosis(possibleDiagnosis.getSelectedItem()) kada se baza uradi
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
				CbrResult.potentialMedications.clear();
				CbrResult.potentialProcedures.clear();
				NewDiagnosisCaseBased ndcb = new NewDiagnosisCaseBased(examination);
				ndcb.setVisible(true);
				dispose();
			}
		});
	}


}
