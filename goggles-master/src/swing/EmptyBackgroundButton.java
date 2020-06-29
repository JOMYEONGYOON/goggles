package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import manager.ResourceManager;

public class EmptyBackgroundButton extends JButton{
	private long time;
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public EmptyBackgroundButton(String name) {
		super(name);
		setFont(new Font("나눔손글씨 펜", Font.PLAIN, 24));
		setForeground(Color.white);
		setBorderPainted(false);
		setBorder(new MatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
		super.setBackground(ResourceManager.NONE);
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        setForeground(Color.YELLOW);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setForeground(Color.white);
		    }
		});
	}

}
