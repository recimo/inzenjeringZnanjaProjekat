package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import neurology.app.model.Examination;

public class NewDiagnosis extends JDialog{

	private JPanel mainPanel;
	//private JList diagnosisList;
	private Examination exam;
	
	public NewDiagnosis(Examination e) {
		this.exam = e;
	}
	
	
	public void initDialog() {
		this.setTitle("Diagnosis result");
		this.setPreferredSize(new Dimension(400, 400));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}
	
	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new FlowLayout());
		
		this.add(mainPanel);
		
		this.initComponents();
		//action listeners
	}
	
	public void initComponents() {
	
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>(model);
		
		//TESTNI PRIMER
		for(int i = 0; i < 5; ++i) {
			model.addElement("Test: " + i);
		}
		
		
		this.mainPanel.add(list);
	}
}
