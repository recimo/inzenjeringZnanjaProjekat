package neurology.app.view.patientFrame.tabbedPane.anamnesis;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SpringLayout;

import neurology.app.model.anamnesis.PersonalAnamnesis;
import neurology.app.view.SpringUtilities;

public class PersonalAnamnesisListRenderer extends JPanel implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 1L;
	private JLabel lackLabel;
	private JLabel disturbanceLabel;
	private JLabel headacheLabel;
	private JLabel sightLabel;
	private JLabel hearingLabel;
	private JLabel balanceLabel;
	private JLabel limbsLabel;

	private JCheckBox lackBox;
	private JCheckBox disturbanceBox;
	private JLabel headacheBox;
	private JLabel sightBox;
	private JCheckBox hearingBox;
	private JCheckBox balanceBox;
	private JCheckBox limbsBox;

	public PersonalAnamnesisListRenderer() {

		this.setLayout(new SpringLayout());
		this.setVisible(true);
		this.initComponents();
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

		this.setOpaque(true);

	}

	public void initComponents() {

		this.lackLabel = new JLabel("LOEAI: ", JLabel.TRAILING);
		this.lackBox = new JCheckBox();
		this.lackBox.setEnabled(false);
		this.lackLabel.setLabelFor(lackBox);

		this.disturbanceLabel = new JLabel("DOM:", JLabel.TRAILING);
		this.disturbanceBox = new JCheckBox();
		this.disturbanceBox.setEnabled(false);
		this.disturbanceLabel.setLabelFor(disturbanceBox);

		this.headacheLabel = new JLabel("Headache type:", JLabel.TRAILING);
		this.headacheBox = new JLabel();
		this.headacheLabel.setLabelFor(headacheBox);

		this.sightLabel = new JLabel("Sight:", JLabel.TRAILING);
		this.sightBox = new JLabel();
		this.sightLabel.setLabelFor(sightBox);

		this.hearingLabel = new JLabel("Hearing loss:", JLabel.TRAILING);
		this.hearingBox = new JCheckBox();
		this.hearingBox.setEnabled(false);
		this.hearingLabel.setLabelFor(hearingBox);

		this.balanceLabel = new JLabel("Balance loss:", JLabel.TRAILING);
		this.balanceBox = new JCheckBox();
		this.balanceBox.setEnabled(false);
		this.balanceLabel.setLabelFor(balanceBox);

		this.limbsLabel = new JLabel("Limbs pain:", JLabel.TRAILING);
		this.limbsBox = new JCheckBox();
		this.limbsBox.setEnabled(false);
		this.limbsLabel.setLabelFor(limbsBox);

	}

	public void addComponents() {

		this.add(lackLabel);
		this.add(disturbanceBox);

		this.add(disturbanceLabel);
		this.add(lackBox);

		this.add(headacheLabel);
		this.add(headacheBox);

		this.add(sightLabel);
		this.add(sightBox);

		this.add(hearingLabel);
		this.add(hearingBox);

		this.add(balanceLabel);
		this.add(balanceBox);

		this.add(limbsLabel);
		this.add(limbsBox);

		SpringUtilities.makeCompactGrid(this, 7, 2, 6, 6, 6, 6);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (value instanceof PersonalAnamnesis) {
			PersonalAnamnesis temp = (PersonalAnamnesis) value;

			this.lackBox.setSelected(temp.isLackOfEnergyAndInterest());
			this.disturbanceBox.setSelected(temp.isDisturbanceOfMemory());
			this.headacheBox.setText(temp.getHeadache().toString());
			this.sightBox.setText(temp.getSight().toString());
			this.hearingBox.setSelected(temp.isHearingLoss());
			this.balanceBox.setSelected(temp.isBalanceLoss());
			this.limbsBox.setSelected(temp.isLimbsPain());

			this.addComponents();
		}

		this.setEnabled(list.isEnabled());

		return this;
	}

}
