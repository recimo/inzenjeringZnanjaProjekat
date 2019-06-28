package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neurology.app.miscellaneous.CBRFinder;
import neurology.app.miscellaneous.CbrResult;
import neurology.app.model.DiagnosisModel;
import neurology.app.model.Examination;

public class NewDiagnosisCaseBased extends JDialog {

	private Examination examination;
	private JPanel mainPanel;

	private JLabel chooseDiagnose;


	public JComboBox<String> possibleDiagnosis;
	public ArrayList<String> calculatedDiagnosis = new ArrayList<>();
	public ArrayList<Double> calculatedPercenteges = new ArrayList<>();
	private DiagnosisModel selectedDiagnosis = new DiagnosisModel();

	private JButton okButton;
	private JButton cancelButton;
	private JButton backButton = new JButton();

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	public NewDiagnosisCaseBased(Examination examination) {
		this.examination = examination;


		CBRFinder recommender = new CBRFinder();
		recommender.predvidjajDijagnozu(0, this.examination); // 0 da bi znao cycle za da treba da predvidja dijagnozu,
																// jer cycle ne sme parametre da prima

		Iterator it = CbrResult.potentialDiagnosis.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String temp = (String) pair.getKey() + " " + (Double) pair.getValue();

			calculatedDiagnosis.add(temp);
			calculatedPercenteges.add((Double) pair.getValue());
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}

		this.initDialog();
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Diagnosis");
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

		this.chooseDiagnose = new JLabel("Choose Diagnosis:");
		this.chooseDiagnose.setPreferredSize(labelDim);

		String[] diagnosis = new String[calculatedDiagnosis.size()];
		diagnosis = calculatedDiagnosis.toArray(diagnosis);
		this.possibleDiagnosis = new JComboBox<String>(diagnosis);
		this.possibleDiagnosis.setPreferredSize(fieldDim);

		this.mainPanel.add(chooseDiagnose);
		this.mainPanel.add(possibleDiagnosis);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

		JPanel panel = new JPanel();

		panel.add(okButton);
		panel.add(cancelButton);
		this.add(panel, BorderLayout.SOUTH);

		// kada se baza napravi onda iz baze dijagnoze
		String[] temp = possibleDiagnosis.getSelectedItem().toString().split(" ");

		selectedDiagnosis.setDiagnosisName(temp[0]);
		System.out.println("Inicijalno : " + selectedDiagnosis.getDiagnosisName());

	}

	public void initActionListeners() {

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// examination.setFinalDiagnosisModel(baza.getDiagnose(selectedDiagnosis));
				examination.setFinalDiagnosisModel(selectedDiagnosis);
				CbrResult.potentialDiagnosis.clear();
				NewMedicationProcedureCaseBased newMed = new NewMedicationProcedureCaseBased(examination);
				newMed.setVisible(true);

				dispose();
			}
		});

		this.possibleDiagnosis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] temp = possibleDiagnosis.getSelectedItem().toString().split(" ");

				selectedDiagnosis.setDiagnosisName(temp[0]);
				// selectedDiagnosis = baza.getDiagnosis(possibleDiagnosis.getSelectedItem())
				// kada se baza uradi
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
				NewPhysicalExamination npe = new NewPhysicalExamination(examination);
				npe.setVisible(true);
				dispose();
			}
		});
	}

}
