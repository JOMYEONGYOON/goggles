package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;

public class EmptyBackgroundTextArea extends JTextArea{
	public EmptyBackgroundTextArea() {
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		setForeground(ResourceManager.BLACK);
		setBackground(ResourceManager.WHITE_ALPHA);
		setOpaque(false);
	}
}
