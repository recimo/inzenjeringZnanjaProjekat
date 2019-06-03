package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import neurology.app.model.Examination;
import neurology.app.model.Symptom;

public class NewDiagnosis extends JDialog {

	private DefaultListModel<String> modelList;
	private JList<String> diagnosisList;

	// private List diagnosis
	// popuni listu kad preuzmes

	private JScrollPane scrollPane;

	private Examination examination;

	public NewDiagnosis(Examination examination) {
		// kad napravis to za uzimanje dijagnoza
		// samo u konstruktor prosledi neku listu dojagnoza
		this.examination = examination;
	}

	public void initDialog() {
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

	public void initComponents() {
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

		// for(int i = 0; i < prosledjenaLista.size(): i++){
		// this.modelList.add(i, prosledjenaLista.get(i).getName());
		// }
		// this.diagnosisList.setVisibleRowCount(prosledjenaLista.size());
		
		//ovo ubacis umesto ovoga dole
		
		//

		for (int i = 0; i < 5; i++) {
			this.modelList.add(i, "TEMP: " + i);

		}

		this.diagnosisList.setVisibleRowCount(5);

	}

}