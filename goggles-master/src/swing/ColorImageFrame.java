package swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import manager.ResourceManager;

public class ColorImageFrame extends JFrame{

	public ColorImageFrame(String imagePath, Color color) {
		setLayout(null);
		ImagePanel imagePanel = new ImagePanel(imagePath);
		setSize(ResourceManager.FRAME_WIDTH,ResourceManager.FRAME_HEIGHT );
		ColorPanel colorPanel = new ColorPanel(color);
		colorPanel.setBounds(12,12, ResourceManager.FRAME_WIDTH-36,ResourceManager.FRAME_HEIGHT-60);
		add(colorPanel, BorderLayout.CENTER);
		add(imagePanel, BorderLayout.CENTER);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new ColorImageFrame("resources\\image\\particle.jpg", ResourceManager.WHITE_ALPHA);
	}
}
