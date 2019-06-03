package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
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
			"chronic_sinusitis", "concussion_bayes", "dementia_bayes", "depression_bayes", 
			"epilepsy_bayes", "lumbago_bayes", "migraine_bayes", "parkinson_disease_bayes", 
			"stroke_bayes" };

	private ArrayList<DiagnosisModel> dijagnoze; 

	private JScrollPane scrollPane;

	private Examination examination;

	public NewDiagnosis(Examination examination) throws LoadException, IOException {
		// kad napravis to za uzimanje dijagnoza
		// samo u konstruktor prosledi neku listu dojagnoza
		this.examination = examination;
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
		this.add(scrollPane);

	}

	public void initComponents() throws LoadException, IOException {
		this.diagnosisList = new JList<String>();
		this.modelList = new DefaultListModel<String>();
		this.diagnosisList.setModel(modelList);

		this.diagnosisList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (diagnosisList.getSelectedIndex() != -1) {

				}
			}
		});
		
		dijagnoze = new ArrayList<>();
		BayesController bc = new BayesController();
		//for(int i = 0; i < bajesFajlovi.length; ++i) {
			DiagnosisModel dijagnoza = bc.CreateBayesNet("stroke_bayes", examination.getSymptoms());
			dijagnoze.add(dijagnoza);
		//}

		for(int i = 0; i < dijagnoze.size(); i++){		
			this.modelList.add(i, dijagnoze.get(i).getDiagnosisName());
		}
		this.diagnosisList.setVisibleRowCount(dijagnoze.size());
		

//		for (int i = 0; i < 5; i++) {
//			this.modelList.add(i, "TEMP: " + i);
//
//		}

		//this.diagnosisList.setVisibleRowCount(5);

	}

}