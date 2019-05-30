package neurology.app;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import neurology.app.view.mainFrame.MainFrame;

public class Application {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);

				} catch (Exception e) {
					System.out.println("nije ucitan LookAndFeel!");
				}

				
				MainFrame mainFrame = new MainFrame();
				Singleton.getInstance().setMainFrame(mainFrame);

				mainFrame.setVisible(true);
			}
		});
	}

}
