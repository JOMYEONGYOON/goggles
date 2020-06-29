package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class WhiteLabel extends JLabel {
	public WhiteLabel() {
		super();
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 20));
		setForeground(Color.WHITE);
	}

	public WhiteLabel(String name) {
		super(name);
		setForeground(Color.WHITE);
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 20));
	}
}
