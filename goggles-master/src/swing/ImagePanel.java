package swing;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import manager.ResourceManager;

public class ImagePanel extends JPanel {
	private Image bgMainImage = null;

	public Image getBgMainImage() {
		return bgMainImage;
	}
	public void changeImage(String path) {
		try {
			this.bgMainImage = ImageIO.read(new File(path));
			setSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));
			setPreferredSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	public void setBgMainImage(Image bgMainImage) {
		this.bgMainImage = bgMainImage;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgMainImage, 0, 0, null);
	}

	public Dimension getDimension() {
		return new Dimension();
	}

	public ImagePanel(String path) {
		try {
			this.bgMainImage = ImageIO.read(new File(path));
			setSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));
			setPreferredSize(new Dimension(ResourceManager.FRAME_WIDTH, ResourceManager.FRAME_HEIGHT));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}