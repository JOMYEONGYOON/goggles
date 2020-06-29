package task6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
interface IntegerConsumeService {
	default public void consume(Integer integer) {
		if (integer == 0) {
			try {
				wait(); // 바의 크기가 0이면 바의 크기가 0보다 커질 때까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		integer = integer-1; //integer--;
		
		notify(); // 기다리는 이벤트 스레드 깨우기
	}

}
class BarLabelController implements Runnable, IntegerConsumeService{
	private BarLabel barLabel;
	private Integer integer;
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
				consume(integer);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class BarLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private int barSize = 0; // 현재 그려져야할 바의 크기
	private int maxBarSize; // 바의 최대 크

	public BarLabel() {
		this.maxBarSize = 100;
	}

	public BarLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
		this.setBackground(Color.ORANGE);
		this.setOpaque(true);

		Thread th = new Thread(new BarLabelController()); // 스레드 생성
		th.start(); // 스레드 시작

	}

	

	synchronized public void fill() {
		if (barSize == maxBarSize) {
			try {
				System.out.println("fill wait");
				wait(); // 바의 크기가 최대이면, ComsumerThread에 의해 바의 크기가 줄어들때까지 대기
				System.out.println("resume");
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint(); // 바의 크기가 변했으니 다시 그리기
		notify(); // 기다리는 ConsumerThread 스레드 깨우기
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) (this.getWidth())) / maxBarSize * barSize);
		if (width == 0)
			return; // 크기가 0이기 때문에 바를 그릴 필요 없음
		g.fillRect(0, 0, width, this.getHeight());
	}
}