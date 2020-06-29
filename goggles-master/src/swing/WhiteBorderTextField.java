package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;

public class WhiteBorderTextField extends JTextField {
	public WhiteBorderTextField() {
		setBackground(ResourceManager.NONE);
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 16));
		setForeground(Color.white);
	}
}