package task5;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import swing.ImagePanel;
class UpgradeImagePanel{
	
}
public class ImagePanelTest extends JFrame{
	public ImagePanelTest() {
		ImagePanel imagePanel = new ImagePanel("resources/image/particle.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(600,400);
		add(imagePanel, BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ImagePanelTest();
	}
}
