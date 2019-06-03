package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import neurology.app.miscellaneous.BayesController;
import neurology.app.model.DiagnosisModel;
import neurology.app.model.Examination;
import unbbayes.io.exception.LoadException;

public class NewDiagnosis extends JDialog {

	private DefaultListModel<String> modelList;
	private JList<String> diagnosisList;
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
		// samo u konstruktor prosledi neku listu dojagnoza
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
		this.diagnosisList = new JList<String>();
		this.modelList = new DefaultListModel<String>();
		this.diagnosisList.setModel(modelList);
		this.okButton = new JButton("Ok");
		this.okButton.setPreferredSize(new Dimension(100, 25));

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		this.diagnosisList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (diagnosisList.getSelectedIndex() != -1) {
					selectedDiagnosis = dijagnoze.get(diagnosisList.getSelectedIndex());

				}
			}
		});

		dijagnoze = new ArrayList<>();
		BayesController bc = new BayesController();
		for (int i = 0; i < bajesFajlovi.length; ++i) {
			DiagnosisModel dijagnoza = bc.CreateBayesNet(bajesFajlovi[i], examination.getSymptoms());
			if (!dijagnoza.getDiagnosisName().equals("Empty")) {
				dijagnoze.add(dijagnoza);
			}

		}

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

				this.modelList.add(n, this.dijagnoze.get(i).getDiagnosisName() + " "
						+ this.dijagnoze.get(i).getDiagnosisPercentage());
				n++;
			}
		}
		this.diagnosisList.setVisibleRowCount(dijagnoze.size());

	}

}