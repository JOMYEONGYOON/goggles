package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;

public class WhiteBorderPasswordField extends JPasswordField {
	public WhiteBorderPasswordField() {
		setForeground(Color.white);
		setBackground(ResourceManager.NONE);
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 16));
	}
}