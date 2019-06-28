package neurology.app.view.patientFrame.tabbedPane.anamnesis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.model.anamnesis.PersonalAnamnesis;
import neurology.app.model.local.AnamnesisFamily;
import neurology.app.model.local.AnamnesisPersonal;

public class AnamnesisPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private AnamnesisFamily familyAnamnesis;
	private AnamnesisPersonal personalAnamnesis;

	private JPanel leftPanel;
	private JPanel rightPanel;

	private JList<PersonalAnamnesis> personalAnamnesisList;
	private DefaultListModel<PersonalAnamnesis> personalAnamnesisModelList;
	private JScrollPane personalScrollPane;

	private JList<FamilyAnamnesis> familyAnamnesisList;
	private DefaultListModel<FamilyAnamnesis> familyAnamnesisModelList;
	private JScrollPane familyScrollPane;

	public AnamnesisPanel(AnamnesisPersonal personal, AnamnesisFamily family) {

		this.familyAnamnesis = family;
		this.personalAnamnesis = personal;

		this.setLayout(new GridLayout(1, 1));
		this.initPanels();

	}

	public void initPanels() {
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(new BorderLayout());
		this.leftPanel.setVisible(true);
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new BorderLayout());
		this.rightPanel.setVisible(true);

		this.initComponents();

		this.personalAnamnesisList.getVisibleRowCount();
		this.personalAnamnesisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.personalScrollPane = new JScrollPane(this.personalAnamnesisList);
		this.leftPanel.add(personalScrollPane, BorderLayout.CENTER);
		this.add(leftPanel, BorderLayout.EAST);

		this.familyAnamnesisList.getVisibleRowCount();
		this.familyAnamnesisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.familyScrollPane = new JScrollPane(this.familyAnamnesisList);
		this.rightPanel.add(familyScrollPane, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.WEST);

		this.setVisible(true);
	}

	public void initComponents() {

		this.personalAnamnesisList = new JList<PersonalAnamnesis>();
		this.personalAnamnesisModelList = new DefaultListModel<PersonalAnamnesis>();
		this.personalAnamnesisList.setModel(personalAnamnesisModelList);
		this.personalAnamnesisList.setCellRenderer(new PersonalAnamnesisListRenderer());

		this.familyAnamnesisList = new JList<FamilyAnamnesis>();
		this.familyAnamnesisModelList = new DefaultListModel<FamilyAnamnesis>();
		this.familyAnamnesisList.setCellRenderer(new FamilyAnamnesisListRenderer());
		this.familyAnamnesisList.setModel(familyAnamnesisModelList);

		this.initModels();

	}

	public void initModels() {
		ArrayList<PersonalAnamnesis> tempPersonal = this.personalAnamnesis.getPersonalAnamnesis();
		for (int i = 0; i < tempPersonal.size(); i++) {
			this.personalAnamnesisModelList.add(i, tempPersonal.get(i));
		}

		this.personalAnamnesisList.setVisibleRowCount(tempPersonal.size());

		ArrayList<FamilyAnamnesis> tempFamily = this.familyAnamnesis.getAnamnesisFamily();
		for (int i = 0; i < tempFamily.size(); i++) {
			this.familyAnamnesisModelList.add(i, tempFamily.get(i));
		}

		this.familyAnamnesisList.setVisibleRowCount(tempFamily.size());

	}
}
