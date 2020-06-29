package runner;

import java.awt.Color;

import swing.WhiteLabel;

public class FadeLabelRunner extends Thread {
	private WhiteLabel successLabel;

	public FadeLabelRunner(WhiteLabel successLabel) {
		this.successLabel = successLabel;
	}

	@Override
	public void run() {
		int count = 0;
		while (count < 255) {
//			System.out.println(count);
			Color color = new Color(1.0F, 1.0F, 1.0F, count / 255.0F);
			successLabel.setForeground(color);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (count > 0) {
//			System.out.println(count);
			Color color = new Color(1.0F, 1.0F, 1.0F, count / 255.0F);
			successLabel.setForeground(color);
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count--;
		}
	}

}
