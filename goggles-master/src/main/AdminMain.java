package main;

import java.awt.EventQueue;

import swing.DatabaseManagerFrame;

public class AdminMain {
	public static void main(String[] args) {
		// Java Runnable window builder Thread runner
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseManagerFrame window = new DatabaseManagerFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
