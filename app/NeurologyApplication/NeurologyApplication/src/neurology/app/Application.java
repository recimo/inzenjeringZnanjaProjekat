package neurology.app;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import neurology.app.controller.dataBase.patient.GetPatients;
import neurology.app.model.Patient;
import neurology.app.view.mainFrame.MainFrame;

public class Application {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {
					// UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
					UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");

					// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);

				} catch (Exception e) {
					System.out.println("nije ucitan LookAndFeel!");
				}

				GetPatients getPatients = new GetPatients();
				if (getPatients.getPatients()) {
					System.out.println("PACIJENTI: ");
					for (Patient patient : Singleton.getInstance().getPatients().getPatients()) {
						System.out.println(patient.getIdentificationNumber());
						System.out.println(patient.getFirstName());
						System.out.println(patient.getLastName());
						System.out.println(patient.getDateOfBirth());
						System.out.println(patient.getGenderOfPatient().toString());
						System.out.println(patient.isRightHanded());
					}
				}

				MainFrame mainFrame = new MainFrame();
				Singleton.getInstance().setMainFrame(mainFrame);

				mainFrame.setVisible(true);
			}
		});
	}

}
