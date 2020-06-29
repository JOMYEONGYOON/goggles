package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;

public class EmptyBackgroundComboBox extends JComboBox<String>{
	public EmptyBackgroundComboBox() {
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		setForeground(Color.white);
		setBackground(ResourceManager.NONE);
		setOpaque(false);
	}

}
