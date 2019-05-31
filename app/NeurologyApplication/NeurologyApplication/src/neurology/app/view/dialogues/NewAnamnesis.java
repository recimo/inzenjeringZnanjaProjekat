package neurology.app.view.dialogues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import neurology.app.controller.AnamnesisCreateAction;
import neurology.app.enumerations.ChangeOfSight;
import neurology.app.enumerations.HeadacheType;
import neurology.app.model.anamnesis.PersonalAnamnesis;

public class NewAnamnesis extends JDialog {
	
	private PersonalAnamnesis newPersonalAnamnesis;
	
	private JPanel mainPanel;
	
	private JLabel vaccinedLabel;
	private JLabel febrileStateLabel; // temperature nepoznatog porekla
	private JLabel lackOfEnergyAndInterestLabel;
	private JLabel disturbanceOfMemoryLabel;
	private JLabel headacheLabel; //combo box
	private JLabel sightLabel; // combo box
	private JLabel hearingLossLabel;
	private JLabel balanceLossLabel;
	private JLabel vertigoLabel;
	private JLabel limbsPainLabel;
	
	private JCheckBox vaccineCheckBox;
	private JCheckBox febrileStateCheckBox;
	private JCheckBox lackOfEnergyAndInterestCheckBox;
	private JCheckBox disturbanceOfMemoryCheckBox;
	private JComboBox<String> headacheField;
	private JComboBox<String> sightField;
	private JCheckBox hearingLossCheckBox;
	private JCheckBox balanceLossCheckBox;
	private JCheckBox vertigoCheckBox;
	private JCheckBox limbsPainCheckBox;
	
	private Dimension buttonDim;
	private Dimension fieldDim;
	private Dimension labelDim;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private String[] headacheType = { HeadacheType.NoHeadche.toString(), HeadacheType.Pulsating.toString(),
									HeadacheType.Pressure.toString(), HeadacheType.Tearing.toString(), HeadacheType.Flank.toString() };
	
	private String[] changeOfSight = { ChangeOfSight.Blur.toString(), ChangeOfSight.DoubleVision.toString(),
										ChangeOfSight.LoosingSightFull.toString(), ChangeOfSight.LoosingSightHalf.toString() };
	
	
	public NewAnamnesis() {
		this.newPersonalAnamnesis = new PersonalAnamnesis();
		this.initDialog();
	}
	
	public void initDialog() {
		this.setTitle("New Anamnesis");
		this.setPreferredSize(new Dimension(220, 600));
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initPanel();
	}
	
	public void initPanel() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new FlowLayout()); //srediti layout

		this.add(mainPanel, BorderLayout.CENTER);

		this.initComponents();
		this.initActionListeners();
	}
	
	public void initComponents() {

		this.labelDim = new Dimension(100, 25);
		this.buttonDim = new Dimension(100, 25);
		this.fieldDim = new Dimension(200, 25);

		this.vaccinedLabel = new JLabel("Vaccined?");
		this.vaccineCheckBox = new JCheckBox();
		this.vaccinedLabel.setPreferredSize(labelDim);

		this.mainPanel.add(vaccinedLabel);
		this.mainPanel.add(vaccineCheckBox);

		this.febrileStateLabel = new JLabel("Febrile State?");
		this.febrileStateCheckBox = new JCheckBox();
		this.febrileStateLabel.setPreferredSize(labelDim);

		this.mainPanel.add(febrileStateLabel);
		this.mainPanel.add(febrileStateCheckBox);
		
		this.lackOfEnergyAndInterestLabel = new JLabel("Lack of energy/interest?");
		this.lackOfEnergyAndInterestCheckBox = new JCheckBox();
		this.lackOfEnergyAndInterestLabel.setPreferredSize(labelDim);

		this.mainPanel.add(lackOfEnergyAndInterestLabel);
		this.mainPanel.add(lackOfEnergyAndInterestCheckBox);
		
		this.disturbanceOfMemoryLabel = new JLabel("Disturbance of memory?");
		this.disturbanceOfMemoryCheckBox = new JCheckBox();
		this.disturbanceOfMemoryLabel.setPreferredSize(labelDim);

		this.mainPanel.add(disturbanceOfMemoryLabel);
		this.mainPanel.add(disturbanceOfMemoryCheckBox);

		this.headacheLabel = new JLabel("Headache type:");
		this.headacheField = new JComboBox<String>(headacheType);
		this.headacheLabel.setPreferredSize(labelDim);
		this.headacheField.setPreferredSize(fieldDim);

		this.mainPanel.add(headacheLabel);
		this.mainPanel.add(headacheField);
		
		this.sightLabel = new JLabel("Sight:");
		this.sightField = new JComboBox<String>(changeOfSight);
		this.sightLabel.setPreferredSize(labelDim);
		this.sightField.setPreferredSize(fieldDim);

		this.mainPanel.add(sightLabel);
		this.mainPanel.add(sightField);

		this.hearingLossLabel = new JLabel("Hearing loss?");
		this.hearingLossCheckBox = new JCheckBox();
		this.hearingLossLabel.setPreferredSize(labelDim);

		this.mainPanel.add(hearingLossLabel);
		this.mainPanel.add(hearingLossCheckBox);
		
		this.balanceLossLabel = new JLabel("Balance loss?");
		this.balanceLossCheckBox = new JCheckBox();
		this.balanceLossLabel.setPreferredSize(labelDim);

		this.mainPanel.add(balanceLossLabel);
		this.mainPanel.add(balanceLossCheckBox);
		
		this.vertigoLabel = new JLabel("Vertigo?");
		this.vertigoCheckBox = new JCheckBox();
		this.vertigoLabel.setPreferredSize(labelDim);

		this.mainPanel.add(vertigoLabel);
		this.mainPanel.add(vertigoCheckBox);
		
		this.limbsPainLabel = new JLabel("Limbs pain?");
		this.limbsPainCheckBox = new JCheckBox();
		this.limbsPainLabel.setPreferredSize(labelDim);

		this.mainPanel.add(limbsPainLabel);
		this.mainPanel.add(limbsPainCheckBox);

		this.okButton = new JButton("Ok");
		this.cancelButton = new JButton("Cancel");
		this.okButton.setPreferredSize(buttonDim);
		this.cancelButton.setPreferredSize(buttonDim);

		this.mainPanel.add(okButton);
		this.mainPanel.add(cancelButton);

	}
	
	public void initActionListeners() {
		this.okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validation()) {

					AnamnesisCreateAction createAction = new AnamnesisCreateAction();
					createAction.action(newPersonalAnamnesis, vaccineCheckBox.isSelected(), 
							febrileStateCheckBox.isSelected(),
							lackOfEnergyAndInterestCheckBox.isSelected(), disturbanceOfMemoryCheckBox.isSelected(),
							headacheField.getSelectedItem().toString(), sightField.getSelectedItem().toString(),
							hearingLossCheckBox.isSelected(), balanceLossCheckBox.isSelected(), vertigoCheckBox.isSelected(),
							limbsPainCheckBox.isSelected());

					dispose();
				}

			}
		});

		this.cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public boolean validation() {
		return true;
	}
	
}
