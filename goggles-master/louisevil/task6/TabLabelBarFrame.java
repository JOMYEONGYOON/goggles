package task6;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class TabLabelBarFrame extends JFrame {
	private BarLabel barLabel;
	private Container c;
	private static final long serialVersionUID = 1L;

	public TabLabelBarFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);
		barLabel = new BarLabel(100); // 바의 최대 크기를 100으로 설정
		barLabel.setBackground(Color.ORANGE);
		barLabel.setOpaque(true);
		barLabel.setLocation(20, 50);
		barLabel.setSize(300, 20); // 300x20 크기의 바
		c.add(barLabel);
		System.out.println("add");
		// 컨텐트팬에 키 이벤트 핸들러 등록
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				barLabel.fill(); // 키를 누를 때마다 바가 1씩 증가한다.
			}
		});
		setSize(350, 200);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus(); // 컨텐트팬에게 키 처리권 부여
		
	}

	public static void main(String[] args) {
		new TabLabelBarFrame("아무키나 빨리 눌러 바 채우기");
	}
}