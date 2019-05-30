package neurology.app.view.mainFrame.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import neurology.app.view.dialogues.NewMedicalExamination;

public class MenuBar extends JMenuBar {

	private JMenu file;
	private JMenuItem addNewPatientItem;
	private JMenu add;
	private JMenuItem exitItem;

	public MenuBar() {
		super();
		this.initMenuBar();

	}

	public void initMenuBar() {
		this.file = new JMenu("_File");
		this.add = new JMenu("_Add");

		this.addNewPatientItem = new JMenuItem("_New Patient");

		this.exitItem = new JMenuItem("_Exit");

		this.add.add(addNewPatientItem);
		this.file.add(add);

		this.file.addSeparator();
		this.file.add(exitItem);

		this.add(file);

		this.initActionListeners();

	}

	public void initActionListeners() {
		this.addNewPatientItem.addActionListener(new ActionListener() {

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
