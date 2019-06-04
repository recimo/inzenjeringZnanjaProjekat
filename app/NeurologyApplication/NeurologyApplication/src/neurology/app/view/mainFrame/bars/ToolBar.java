package neurology.app.view.mainFrame.bars;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import neurology.app.view.dialogues.NewMedicalExamination;
import neurology.app.view.dialogues.NewPatient;

public class ToolBar extends JToolBar {

	private JButton newExamination;
	private JButton newPatient;
	private JButton searchPatient;

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);

		this.initButtons();
		this.initActionListeners();

		this.setFloatable(true);

	}

	public void initButtons() {
		this.newExamination = new JButton();
		this.newExamination.setToolTipText("Start New Examination");

		ImageIcon examIcon = new ImageIcon("resources/newExam1.png");
		Image icon1 = examIcon.getImage();
		icon1 = icon1.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		examIcon = new ImageIcon(icon1);

		this.newExamination.setIcon(examIcon);

		this.newPatient = new JButton();
		this.newPatient.setToolTipText("New Patient");

		ImageIcon patientIcon = new ImageIcon("resources/newPatient1.png");
		Image icon2 = patientIcon.getImage();
		icon2 = icon2.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		patientIcon = new ImageIcon(icon2);

		this.newPatient.setIcon(patientIcon);

		this.add(newExamination);

		this.add(newPatient);

	}

	private void initActionListeners() {
		this.newExamination.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewMedicalExamination newExamination = new NewMedicalExamination();
				newExamination.setVisible(true);

			}
		});

		this.newPatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NewPatient newPatient = new NewPatient();
				newPatient.setVisible(true);
			}
		});
	}

}
