package task6;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageIconLabelFrame extends JFrame {
	public ImageIconLabelFrame() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// 문자열 레이블 생성
		
		// 이미지 레이블 생성
		ImageIcon beauty = new ImageIcon("resources\\image\\exe.png"); // 이미지 로딩
		JLabel imageLabel = new JLabel(beauty); // 이미지 레이블 생성
		
		add(imageLabel);
		
		setSize(400,600);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ImageIconLabelFrame();
	}
}