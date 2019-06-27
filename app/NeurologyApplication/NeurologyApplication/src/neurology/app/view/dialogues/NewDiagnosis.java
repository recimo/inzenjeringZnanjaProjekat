package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import neurology.app.miscellaneous.BayesController;
import neurology.app.model.DiagnosisModel;
import neurology.app.model.Examination;
import neurology.app.model.ListRenderer;
import unbbayes.io.exception.LoadException;

public class NewDiagnosis extends JDialog {

	private DefaultListModel<DiagnosisModel> modelList;
	private JList<DiagnosisModel> diagnosisList;
	private String[] bajesFajlovi = { "alcohol_abuse_bayes", "anxiety_bayes", "chronic_back_pain_bayes",
			"chronic_sinusitis", "concussion_bayes", "dementia_bayes", "depression_bayes", "epilepsy_bayes",
			"lumbago_bayes", "migraine_bayes", "parkinson_disease_bayes", "stroke_bayes" };

	private ArrayList<DiagnosisModel> dijagnoze;

	private DiagnosisModel selectedDiagnosis;

	private JScrollPane scrollPane;

	private Examination examination;

	private JButton okButton;

	public NewDiagnosis(Examination examination) throws LoadException, IOException {
		// kad napravis to za uzimanje dijagnoza
		// samo u konstruktor prosledi neku listu dijagnoza
		this.examination = examination;
		this.selectedDiagnosis = new DiagnosisModel();
		initDialog();
	}

	public void initDialog() throws LoadException, IOException {
		this.setTitle("Diagnosis result");
		this.setPreferredSize(new Dimension(400, 400));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		this.initComponents();

		this.diagnosisList.getVisibleRowCount();
		this.diagnosisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.diagnosisList);
		this.scrollPane.setSize(380, 380);
		this.scrollPane.setPreferredSize(new Dimension(380, 380));
		this.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();

		panel.add(okButton);

		this.add(panel, BorderLayout.SOUTH);

	}

	public void initComponents() throws LoadException, IOException {
		this.diagnosisList = new JList<DiagnosisModel>();
		this.modelList = new DefaultListModel<DiagnosisModel>();
		this.diagnosisList.setModel(modelList);
		this.diagnosisList.setCellRenderer(new ListRenderer());
		this.okButton = new JButton("Ok");
		this.okButton.setPreferredSize(new Dimension(100, 25));

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				examination.setFinalDiagnosisModel(selectedDiagnosis);
				NewMedicationProcedure newMed = new NewMedicationProcedure(examination);
				newMed.setVisible(true);

				dispose();
			}
		});

		this.diagnosisList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (diagnosisList.getSelectedIndex() != -1) {
					selectedDiagnosis = dijagnoze.get(diagnosisList.getSelectedIndex());

					System.out.println("SELEKTOVANO:" + selectedDiagnosis.getDiagnosisName());
				}
			}
		});

		dijagnoze = new ArrayList<>();
		BayesController bc = new BayesController();
		DiagnosisModel dijagnoza = new DiagnosisModel();
		for (int i = 0; i < bajesFajlovi.length; ++i) {
			try {
				dijagnoza = bc.CreateBayesNet(bajesFajlovi[i], examination.getSymptoms());

				if (!dijagnoza.getDiagnosisName().equals("Empty")) {
					dijagnoze.add(dijagnoza);
				}

			} catch (Exception e) {
				// sluzi ako naidje dijagnoza koja je null
			}

		}
		
		Collections.sort(dijagnoze);

//		for (int i = 0; i < dijagnoze.size() - 1; i++) {
//			for (int j = 1; j < dijagnoze.size(); j++) {
//				if (dijagnoze.get(i).getDiagnosisPercentage() < dijagnoze.get(j).getDiagnosisPercentage()) {
//					DiagnosisModel temp = dijagnoze.get(i);
//
//					dijagnoze.set(i, dijagnoze.get(j));
//					dijagnoze.set(j, temp);
//				}
//			}
//		}
//		

		int n = 0;
		for (int i = 0; i < dijagnoze.size(); i++) {
			if (!dijagnoze.get(i).getDiagnosisName().equals("Empty")) {

				String dij = this.dijagnoze.get(i).getDiagnosisName();
				String output = dij.substring(0, 1).toUpperCase() + dij.substring(1);

				float f = this.dijagnoze.get(i).getDiagnosisPercentage() * 100;

				this.modelList.add(n, dijagnoze.get(i));
				// this.modelList.add(n, output + ": " + f + "%");
				n++;
			}
		}
		this.diagnosisList.setVisibleRowCount(dijagnoze.size());

	}

}