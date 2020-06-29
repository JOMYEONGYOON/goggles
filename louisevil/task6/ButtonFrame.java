package task6;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
class FileListTest {
	public static Vector<File> getFiles() {
		Vector<File> fileList = new Vector<File>();
		File target = new File("jpg");
		File files[] = target.listFiles();
		String ignoreFileNames[] = { "png", "db" };

		for (int i = 0; i < files.length; i++) {
			boolean ok = true;
			for (int j = 0; j < ignoreFileNames.length; j++) {
				if (files[i].getName().contains(ignoreFileNames[j])) {
					ok = false;
				}

			}
			if (ok) {
				fileList.add(files[i]);
			}
		}
		return fileList;
	}
}
public class ButtonFrame extends JFrame {
	private static int c = 0;
	private Vector<File> files;

	public Vector<File> listFiles() {
		return FileListTest.getFiles();
	}

	public ButtonFrame() {
		JLabel image = new JLabel("");
		JPanel north = new JPanel();
		JButton right = new JButton("Right");
		JButton left = new JButton("Left");

		getContentPane().add(north, BorderLayout.NORTH);
		files = listFiles();
		
		
		left.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c--;
				if (c <= 0) {
					c = 0 ;
					left.setVisible(false);
				}else {
					left.setVisible(true);
					
				}
				image.setIcon(new ImageIcon(files.get(c).getAbsolutePath()));
				
			}
		});
		right.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c++;
				if (c <= 3) {
					c= 3;
					right.setVisible(false);
				}else {
					right.setVisible(true);
				}
				image.setIcon(new ImageIcon(files.get(c).getAbsolutePath()));
				
			}
		});
		north.add(left);
		north.add(right);

		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon(files.get(0).getAbsolutePath()));
		getContentPane().add(image, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(330, 380);
		setVisible(true);
	}

	public static void main(String[] args) {
//		FileListTest.getFiles();
		new ButtonFrame();//
	}
}
