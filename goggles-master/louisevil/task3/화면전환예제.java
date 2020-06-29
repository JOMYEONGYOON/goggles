package task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
class LoginFrame extends JFrame {
	public LoginFrame() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLayout(new BorderLayout());
		JButton button = new JButton("회원가입화면으로");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.this.dispose();
				new SignUpFrame();
				
			}
		});
		add(button, BorderLayout.CENTER);
		setVisible(true);
	}
}
class SignUpFrame extends JFrame {
	public SignUpFrame() {
		setTitle("회원가입");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		JButton button = new JButton("로그인화면으로");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame.this.dispose();
				new LoginFrame();
				
			}
		});
		setVisible(true);
	}
}

public class 화면전환예제 extends JFrame {
	public static void main(String[] args) {
		new LoginFrame();
	}
}
