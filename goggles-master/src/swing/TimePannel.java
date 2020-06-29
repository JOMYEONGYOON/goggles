package swing;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import manager.ResourceManager;

public class TimePannel extends JPanel {
	private JLabel timerLabel;

	public TimePannel() {
		setBackground(ResourceManager.NONE);
		setLayout(null);
		// 타이머 값을 출력할 레이블 생성
		timerLabel = new JLabel("");
		add(timerLabel);
		timerLabel.setSize(500, 100);
		timerLabel.setFont(new Font("나눔손글씨 펜", Font.PLAIN, 36));
		timerLabel.setForeground(Color.white);
		
		Thread th = new Thread() {
			@Override
			public void run() {
				while (true) { // 무한 루프
					SimpleDateFormat formatter = new SimpleDateFormat("YY-MM-dd HH:mm:ss", Locale.KOREA);
					Calendar c = Calendar.getInstance();
					String dTime = formatter.format(c.getTime());
					timerLabel.setText(dTime);
					try {
						Thread.sleep(1000); // 1초 동안 잠을 잔다.

					} catch (InterruptedException e) {
						return; // 예외가 발생하면 스레드 종료
					}
				}
			}
		};
		th.start();
		add(timerLabel); // 레이블을 컨텐트팬에 부착
		setVisible(true);
	}

}