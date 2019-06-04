package neurology.app.view.mainFrame.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import neurology.app.view.dialogues.NewMedicalExamination;
import neurology.app.view.dialogues.NewPatient;

public class MenuBar extends JMenuBar {

	private JMenu file;
	private JMenuItem addNewPatientItem;
	private JMenuItem addNewExaminationItem;
	private JMenu neW;
	private JMenuItem exitItem;

	public MenuBar() {
		super();
		this.initMenuBar();

	}

	public void initMenuBar() {
		this.file = new JMenu("File");
		this.file.setMnemonic('F');

		this.neW = new JMenu("New");
		this.neW.setMnemonic('N');

		this.addNewPatientItem = new JMenuItem("New Patient");
		this.addNewPatientItem.setMnemonic('P');

		this.addNewExaminationItem = new JMenuItem("New Examination");
		this.addNewExaminationItem.setMnemonic('E');

		this.exitItem = new JMenuItem("Exit");

		this.neW.add(addNewPatientItem);
		this.neW.add(addNewExaminationItem);
		this.file.add(neW);

		this.file.addSeparator();
		this.file.add(exitItem);

		this.add(file);

		this.initActionListeners();

	}

	public void initActionListeners() {
		this.addNewPatientItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewPatient newPatient = new NewPatient();
				newPatient.setVisible(true);

			}
		});

		this.addNewExaminationItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewMedicalExamination newPatientDialog = new NewMedicalExamination();
				newPatientDialog.setVisible(true);
			}
		});

		this.exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
