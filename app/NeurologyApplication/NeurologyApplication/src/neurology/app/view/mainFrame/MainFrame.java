package neurology.app.view.mainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import neurology.app.view.mainFrame.bars.MenuBar;

public class MainFrame extends JFrame {

	private MenuBar menuBar;
	private JPanel mainPanel;

	public MainFrame() {

		this.initFrame();

	}

	public void initFrame() {
		this.initMenuBar();

		this.setJMenuBar(menuBar);
		this.setTitle("Test");
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initMenuBar() {
		this.menuBar = new MenuBar();
		this.mainPanel = new JPanel();
	}
}
