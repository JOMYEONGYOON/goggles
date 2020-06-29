package task6;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CounterFrame extends JFrame {
	private JLabel timerLabel;
	private CountRunable countRunnable;

	class JLabelCounterRunnable implements Runnable {
		public JLabelCounterRunnable() {
			countRunnable = new CountRunable(0);
			Thread th = new Thread(countRunnable);
			th.start();
		}

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(500);
					timerLabel.setText(countRunnable.getInteger() + "");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static final long serialVersionUID = 1L;
	private Integer n = new Integer(0);

	public CounterFrame() {
		setTitle("ThreadInterruptEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 타이머 값을 출력할 레이블 생성
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 100));
		JLabelCounterRunnable jLabelCounterRunnable = new JLabelCounterRunnable();
		c.add(timerLabel);
		Thread thread = new Thread(jLabelCounterRunnable);
		thread.start();
		// 버튼을 생성하고 Action 리스너 등록
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				btn.setEnabled(false); // 버튼 비활성화
				thread.stop();
			}
		});
		c.add(btn);

		setSize(300, 170);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CounterFrame();
	}
}