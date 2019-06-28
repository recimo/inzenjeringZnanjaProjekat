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

import neurology.app.model.anamnesis.FamilyAnamnesis;
import neurology.app.view.SpringUtilities;

public class FamilyAnamnesisListRenderer extends JPanel implements ListCellRenderer<Object> {

	private static final long serialVersionUID = 1L;
	private JLabel diabetesLabel;
	private JLabel endocrineDiseasesLabel;
	private JLabel hypertensionLabel;
	private JLabel cerebrovascularDiseasesLabel;
	private JLabel headacheLabel;
	private JLabel mentalIllnessesLabel;

	private JCheckBox diabetes;
	private JCheckBox endocrineDiseases;
	private JCheckBox hypertension;
	private JCheckBox cerebrovascularDiseases;
	private JCheckBox headache;
	private JCheckBox mentalIllnesses;

	public FamilyAnamnesisListRenderer() {
		this.setLayout(new SpringLayout());
		this.setVisible(true);
		this.initComponents();
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		this.setOpaque(true);
	}

	public void initComponents() {

		this.diabetesLabel = new JLabel("Diabetes: ", JLabel.TRAILING);
		this.diabetes = new JCheckBox();
		this.diabetes.setEnabled(false);
		this.diabetesLabel.setLabelFor(diabetes);

		this.endocrineDiseasesLabel = new JLabel("Endocrine: ", JLabel.TRAILING);
		this.endocrineDiseases = new JCheckBox();
		this.endocrineDiseases.setEnabled(false);
		this.endocrineDiseasesLabel.setLabelFor(endocrineDiseases);

		this.hypertensionLabel = new JLabel("Hypertension: ", JLabel.TRAILING);
		this.hypertension = new JCheckBox();
		this.hypertension.setEnabled(false);
		this.hypertensionLabel.setLabelFor(hypertension);

		this.cerebrovascularDiseasesLabel = new JLabel("Cerebrovascular: ", JLabel.TRAILING);
		this.cerebrovascularDiseases = new JCheckBox();
		this.cerebrovascularDiseases.setEnabled(false);
		this.cerebrovascularDiseasesLabel.setLabelFor(cerebrovascularDiseases);

		this.headacheLabel = new JLabel("Headache: ", JLabel.TRAILING);
		this.headache = new JCheckBox();
		this.headache.setEnabled(false);
		this.headacheLabel.setLabelFor(headache);

		this.mentalIllnessesLabel = new JLabel("Mental illnesses: ", JLabel.TRAILING);
		this.mentalIllnesses = new JCheckBox();
		this.mentalIllnesses.setEnabled(false);
		this.mentalIllnessesLabel.setLabelFor(mentalIllnesses);
	}

	public void addComponents() {
		this.add(diabetesLabel);
		this.add(diabetes);

		this.add(endocrineDiseasesLabel);
		this.add(endocrineDiseases);

		this.add(hypertensionLabel);
		this.add(hypertension);

		this.add(cerebrovascularDiseasesLabel);
		this.add(cerebrovascularDiseases);

		this.add(headacheLabel);
		this.add(headache);

		this.add(mentalIllnessesLabel);
		this.add(mentalIllnesses);

		SpringUtilities.makeCompactGrid(this, 6, 2, 6, 6, 6, 6);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (value instanceof FamilyAnamnesis) {
			FamilyAnamnesis temp = (FamilyAnamnesis) value;
			this.diabetes.setSelected(temp.isDiabetes());
			this.endocrineDiseases.setSelected(temp.isEndocrineDiseases());
			this.hypertension.setSelected(temp.isHypertension());
			this.cerebrovascularDiseases.setSelected(temp.isCerebrovascularDiseases());
			this.headache.setSelected(temp.isHeadache());
			this.mentalIllnesses.setSelected(temp.isMentalIllnesses());

			this.addComponents();
		}
		this.setEnabled(list.isEnabled());

		return this;
	}
}
