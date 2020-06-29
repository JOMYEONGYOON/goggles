package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manager.ResourceManager;

public class ImageFrame extends JFrame {
	private JPanel rootPanel;
	protected String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public JPanel getRootPanel() {
		return rootPanel;
	}

	public void setRootPanel(JPanel rootPanel) {
		this.rootPanel = rootPanel;
	}

	public ImageFrame(String imagePath) {
		this.imagePath = imagePath;
		rootPanel = new ImagePanel(imagePath);
		rootPanel.setBackground(ResourceManager.BLACK);
		rootPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		rootPanel.setLayout(new CardLayout(0, 0));
		setSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));
		setBackground(ResourceManager.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0, 0));
		add(rootPanel);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
