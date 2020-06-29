package main;

import java.awt.EventQueue;

import swing.MainFrame;

public class UserMain {
	public static void main(String[] args) {
		// Java Runnable window builder Thread runner
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// main frame start ui view
					MainFrame window = new MainFrame();
					// show window jframe
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}