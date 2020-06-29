package task6;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HoverButtonFrame extends JFrame {
	public HoverButtonFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ImageIcon normalIcon = new ImageIcon("resources/image/gif/normalIcon.gif"); 
		ImageIcon rolloverIcon = new ImageIcon("resources/image/gif/rolloverIcon.gif"); 
		ImageIcon pressedIcon = new ImageIcon("resources/image/gif/pressedIcon.gif"); 
		
		
		JButton btn = new JButton("call~~", normalIcon); 
		btn.setPressedIcon(pressedIcon); 
		btn.setRolloverIcon(rolloverIcon); 
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new HoverButtonFrame();
	}
}