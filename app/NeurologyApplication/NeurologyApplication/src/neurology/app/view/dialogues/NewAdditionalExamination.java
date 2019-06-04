package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import neurology.app.controller.AdditionalExaminationCreateAction;
import neurology.app.miscellaneous.MySymptomFinder;
import neurology.app.model.AdditionalExamination;
import neurology.app.model.Examination;
import neurology.app.model.Symptom;
import unbbayes.io.exception.LoadException;

public class NewAdditionalExamination extends JDialog {

	private Examination examination;
	private AdditionalExamination additionalExamination;

	private ArrayList<JLabel> labelList = new ArrayList<>();

	private ArrayList<JCheckBox> checkBoxList = new ArrayList<>();

	private JPanel mainPanel;

	private JScrollPane scrollPane;

	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;

	private JButton okButton;
	private JButton cancelButton;

	public NewAdditionalExamination(Examination e) {
		// List<Symptoms>
		this.examination = e;
		additionalExamination = new AdditionalExamination();
		System.out.println(examination.getPhysicalExamination().toString());
		ArrayList<Symptom> calculatedSymptoms = MySymptomFinder.findRelatedSymptoms(examination.getSymptoms());
		ArrayList<Symptom> filteredSymptoms = MySymptomFinder.getOnlyImportantSymptoms(calculatedSymptoms,
				examination.getPatient());
		additionalExamination.setSymptomsToCheck(filteredSymptoms);

		this.initDialog();

		// on ok button popuniti additionalExamination i postaviti u examinations
	}

	public void initDialog() {
		this.setTitle("New Medical Examination: Additional Examination");
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
		this.mainPanel.setLayout(new GridLayout(additionalExamination.getSymptomsToCheck().size() + 1, 2, 10, 30));

		this.scrollPane = new JScrollPane(this.mainPanel);
		this.scrollPane.setSize(700, 500);
		this.scrollPane.setPreferredSize(new Dimension(700, 500));

		this.initComponents();
		this.initActionListeners();

		this.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.add(okButton);
		panel.add(cancelButton);

		this.add(panel, BorderLayout.SOUTH);
	}

	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		for (Symptom symptom : additionalExamination.getSymptomsToCheck()) {
			JLabel label = new JLabel(symptom.getName());
			JCheckBox checkBox = new JCheckBox();
			checkBox.setName(symptom.getName());

			label.setPreferredSize(labelDim);

			this.mainPanel.add(label);
			this.mainPanel.add(checkBox);
			this.labelList.add(label);
			this.checkBoxList.add(checkBox);
		}

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

	}

	public void initActionListeners() {

		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ovde preuzeti sve vrednosti koje je korisnik uneo i dodati i u additional i u
				// examination, sad ide zakucavanje
				// physicalExamination.setMusclesRecognition(NewPhysicalExamination.this.);
				for (JCheckBox jcb : checkBoxList) {
					if (jcb.isSelected()) {
						examination.getSymptoms().add(new Symptom(jcb.getName()));
					}
				}

				AdditionalExaminationCreateAction addCreateAction = new AdditionalExaminationCreateAction();
				addCreateAction.action(examination.getSymptoms());

				NewAdditionalExamination.this.examination
						.setAdditionalExamination(NewAdditionalExamination.this.additionalExamination);

				System.out.println("Simptomi iz liste:");
				for (Symptom s : examination.getSymptoms()) {
					System.out.println(s.getName());
				}

				NewDiagnosis diagnosisDialog = null;
				try {
					diagnosisDialog = new NewDiagnosis(examination);
				} catch (LoadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				diagnosisDialog.setVisible(true);

				dispose();
			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

}
